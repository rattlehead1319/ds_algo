package graph.medium;

public class WordSearch {
    public boolean isWordExist(char[][] board, String word)
    {
        if (board == null || board.length == 0) {
            return false;
        }

        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, i, j, word, 1)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private boolean dfs (char[][] board, int row, int col, String word, int wi) {

        if (wi >= word.length()) {
            return true;
        }

        int rows[] = new int[]{0, -1, 0, 1};
        int cols[] = new int[]{-1, 0, 1, 0};


        char temp = board[row][col];
        board[row][col] = ' ';
        for (int i = 0; i < 4; i++) {
            int nextRow = row + rows[i];
            int nextCol = col + cols[i];

            if (isSafe(board, nextRow, nextCol, word, wi)) {
                if (dfs(board, nextRow, nextCol, word, wi + 1)) {
                    return true;
                }
            }
        }
        board[row][col] = temp;
        return false;
    }

    private boolean isSafe(char[][] board, int nextRow, int nextCol, String word, int wi) {
        return nextRow >= 0 && nextRow < board.length &&
                nextCol >= 0 && nextCol < board[0].length &&
                word.charAt(wi) == board[nextRow][nextCol];
    }
}
