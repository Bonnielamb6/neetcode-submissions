class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Deque<int[]> deque = new ArrayDeque<>();
        for(int row = 0 ; row < grid.length; row++){
            for(int col = 0 ; col < grid[0].length; col++){
                if(grid[row][col] == 0){
                    deque.offer(new int[]{row,col});
                }
            }
        }
        while(!deque.isEmpty()){
            int[] current = deque.poll();
            checkNeighbour(grid, current[0] - 1, current[1], current[0],current[1],deque);
            checkNeighbour(grid, current[0], current[1] - 1, current[0],current[1],deque);
            checkNeighbour(grid, current[0] + 1, current[1], current[0],current[1],deque);
            checkNeighbour(grid, current[0], current[1] + 1, current[0],current[1],deque);
        }
    }

    public void checkNeighbour(int[][]grid,int nr, int nc, int row, int col, Deque<int[]> deque){
        if(nr < 0 || nr > grid.length - 1
        || nc < 0 || nc > grid[0].length - 1
        || grid[nr][nc] == -1){
            return;
        }
        if(grid[nr][nc] == 2147483647){
            grid[nr][nc] = grid[row][col] + 1;
            deque.offer(new int[]{nr,nc});
        }
    }
}
