class Solution {
    int freshFruits = 0;
    public int orangesRotting(int[][] grid) {
        int rottenFruits = 0;
        int time = -1;
        Deque<int[]> deque = new ArrayDeque<>();
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 1) {
                    freshFruits++;
                }
                if (grid[row][col] == 2) {
                    rottenFruits++;
                    deque.offer(new int[]{row, col});
                }
            }
        }
        if (freshFruits == 0) {
            return 0;
        }
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int pointer = 0; pointer < size; pointer++) {
                int[] current = deque.poll();
                rotFruits(grid, current[0] + 1, current[1], deque);
                rotFruits(grid, current[0], current[1] + 1, deque);
                rotFruits(grid, current[0] - 1, current[1], deque);
                rotFruits(grid, current[0], current[1] - 1, deque);
            }
            time++;
        }
        if (freshFruits > 0) {
            return -1;
        }
        return time;
    }

    public void rotFruits(int[][] grid, int row, int col, Deque<int[]> deque) {
        if (row < 0 || row > grid.length - 1 || col < 0 || col > grid[0].length - 1) {
            return;
        }
        if (grid[row][col] == 1) {
            grid[row][col] = 2;
            freshFruits--;
            deque.offer(new int[] {row, col});
        }
    }
}
