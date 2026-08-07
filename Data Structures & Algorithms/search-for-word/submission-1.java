class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        // hacer un for para checar
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (board[row][col] == word.charAt(0)) {
                    if (backtracking(visited, board, word, 0, row, col))
                        return true;
                }
            }
        }

        return false;
    }

    public boolean backtracking(
        boolean[][] visited, char[][] board, String word, int index, int row, int col) {
        if (row < 0 || row > board.length - 1 || col < 0 || col > board[0].length - 1
            || visited[row][col]) {
            return false;
        }
        if (board[row][col] != word.charAt(index))
            return false;
        if (index == word.length() - 1) {
            return true;
        }
        if (board[row][col] == word.charAt(index)) {
            visited[row][col] = true;
            if (backtracking(visited, board, word, index + 1, row + 1, col)
                || backtracking(visited, board, word, index + 1, row, col + 1)
                || backtracking(visited, board, word, index + 1, row - 1, col)
                || backtracking(visited, board, word, index + 1, row, col - 1)) {
                return true;
            }
            visited[row][col] = false;
        }
        return false;
    }
}
