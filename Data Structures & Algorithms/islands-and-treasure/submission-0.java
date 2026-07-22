class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Deque<int[]> deque = new ArrayDeque<>();
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[0].length;j++){
                if(grid[i][j] == 0){
                    deque.offer(new int[]{i,j});
                }
            }
        }

        while(!deque.isEmpty()){
            int[] current = deque.poll();
            checkNeighbour(grid, deque,current[0],current[1],current[0] - 1,current[1]);
            checkNeighbour(grid, deque,current[0],current[1],current[0],current[1] - 1);
            checkNeighbour(grid, deque,current[0],current[1],current[0] + 1,current[1]);
            checkNeighbour(grid, deque,current[0],current[1],current[0],current[1] + 1);
        }
    }

    public void checkNeighbour(int[][] grid, Deque<int[]> deque,int row, int col, int nr, int nc){
        if(nr < 0 
        || nc < 0
        || nr >grid.length - 1
        || nc > grid[0].length - 1){
            return;
        }

        if(grid[nr][nc] == 2147483647){
            grid[nr][nc] = grid[row][col] + 1;
            deque.offer(new int[]{nr, nc});
        }
        return;
    }
        
}
