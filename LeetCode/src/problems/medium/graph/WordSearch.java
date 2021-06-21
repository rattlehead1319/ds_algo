package problems.medium.graph;

public class WordSearch {
    int[] rows = new int[]{0, -1, 0, 1};
    int[] cols = new int[]{-1, 0, 1, 0};

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean[][] visited = new boolean[m][n];
                    if (dfs(board, i, j, visited, word, 1)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs (char[][] board, int i, int j, boolean[][] visited, String word, int wordIndex) {
        if (!visited[i][j]) {
            visited[i][j] = true;
        }
        if (wordIndex == word.length()) {
            return true;
        }

        for (int k = 0; k < 4; k++) {
            int nextRow = i + rows[k];
            int nextCol = j + cols[k];

            if (nextRow >= 0 && nextRow < board.length && nextCol >= 0 && nextCol < board[0].length &&
                    !visited[nextRow][nextCol] && word.charAt(wordIndex) == board[nextRow][nextCol])
            {
                wordIndex++;
                if (dfs(board, nextRow, nextCol, visited, word, wordIndex)) {
                    return true;
                }

                visited[nextRow][nextCol] = false;
                wordIndex--;
            }
        }
        return false;
    }
}
