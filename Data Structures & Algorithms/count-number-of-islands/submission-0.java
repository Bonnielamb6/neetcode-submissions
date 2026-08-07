class Solution {
    int islands = 0;
    public int numIslands(char[][] grid) {
        for(int row = 0; row < grid.length; row++){
            for(int col = 0 ; col < grid[0].length; col++){
                if(grid[row][col] == '1'){
                    eraseIsland(grid, row, col);
                    islands++;
                }
            }
        }
        return islands;
    }

    public void eraseIsland(char[][]grid, int row, int col){
        if(row < 0 || row > grid.length - 1
        || col < 0 || col > grid[0].length - 1
        || grid[row][col] == '0'){
            return;
        }
        grid[row][col] = '0';
        eraseIsland(grid, row + 1,col);
        eraseIsland(grid, row,col + 1);
        eraseIsland(grid, row - 1,col);
        eraseIsland(grid, row,col - 1);
    }
}
