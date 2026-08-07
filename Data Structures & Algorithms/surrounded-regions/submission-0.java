class Solution {
    public void solve(char[][] board) {
        boolean[][] safe = new boolean[board.length][board[0].length];
        for(int row = 0 ; row < board.length ; row++){
            if(board[row][0] == 'O'){
                dfs(board,safe, row,0);
            }
            if(board[row][board[0].length - 1] == 'O'){
                dfs(board,safe, row,board[0].length - 1);
            }
        }
        for(int col = 0 ; col < board[0].length; col++){
            if(board[0][col] == 'O'){
                dfs(board,safe, 0,col);
            }
            if(board[board.length - 1][col] == 'O'){
                dfs(board,safe, board.length - 1,col);
            }
        }
        for(int row = 0 ; row < board.length; row++){
            for(int col = 0 ; col < board[0].length; col++){
                if(board[row][col] == 'O' && safe[row][col] == false){
                    board[row][col] = 'X';
                }
            }
        }

    }

    public void dfs(char[][] board, boolean[][] safe, int row, int col){
        if(row < 0 || row > board.length - 1
        || col < 0 || col > board[0].length - 1
        || safe[row][col] == true
        || board[row][col] == 'X'){
            return;
        }
        safe[row][col] = true;
        dfs(board, safe, row + 1, col);
        dfs(board, safe, row, col + 1);
        dfs(board, safe, row - 1, col);
        dfs(board, safe, row, col - 1);
    }
}
