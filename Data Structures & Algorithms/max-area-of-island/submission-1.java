class Solution {
    int max = 0;
    public int maxAreaOfIsland(int[][] grid) {
        for(int row = 0; row < grid.length; row++){
            for(int col = 0 ; col < grid[0].length; col++){
                if(grid[row][col] == 1){
                    max = Math.max(max, eraseIsland(grid, row, col));
                }
            }
        }
        return max;
    }

    public int eraseIsland(int[][] grid, int row, int col){
        if(row < 0 || row > grid.length - 1
        || col < 0 || col > grid[0].length - 1
        || grid[row][col] == 0){
            return 0;
        }
        int sum = 1;
        grid[row][col] = 0;
        sum += eraseIsland(grid, row + 1,col);
        sum += eraseIsland(grid, row,col + 1);
        sum += eraseIsland(grid, row - 1,col);
        sum += eraseIsland(grid, row,col - 1);
        return sum;
    }
}
