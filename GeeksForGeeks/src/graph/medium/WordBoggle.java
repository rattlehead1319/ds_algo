package graph.medium;

import java.util.*;

//Must visit

public class WordBoggle {
    public String[] wordBoggle(char board[][], String[] dictionary)
    {

        if (board == null || board.length == 0) {
            return new String[0];
        }

        List<String> result = new ArrayList<>();

        int m = board.length;
        int n = board[0].length;


        for (String word: dictionary) {
            boolean breakLoop = false;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] == word.charAt(0) && dfs(board, i, j, word, 1)) {
                        result.add(word);
                        breakLoop = true;
                        break;
                    }
                }
                if (breakLoop) {
                    break;
                }
            }
        }

        return result.toArray(new String[result.size()]);
    }

    private boolean dfs(char[][] board, int row, int col, String word, int wi) {
        if (wi >= word.length()) {
            return true;
        }

        int[] rows = new int[]{0, -1, -1, -1, 0, 1, 1, 1};
        int[] cols = new int[]{-1, -1, 0, 1, 1, 1, 0, -1};

        char temp = board[row][col];
        board[row][col] = ' ';

        for (int i = 0; i < 8; i++) {
            int nextRow = row + rows[i];
            int nextCol = col + cols[i];

            if (isSafe(board, nextRow, nextCol, word, wi)) {
                if (dfs(board, nextRow, nextCol, word, wi + 1)) {
                    board[row][col] = temp;
                    return true;
                }
            }
        }

        board[row][col] = temp;
        return false;
    }

    private boolean isSafe(char[][] board, int row, int col, String word, int wi) {
        return row >= 0 && row < board.length && col >= 0 && col < board[0].length && word.charAt(wi) == board[row][col];
    }
}
