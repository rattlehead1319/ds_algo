package problems.medium.matrix;

import java.util.*;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        //check duplicates in row
        for (int i = 0; i < m; i++) {
            Set<Character> filled = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if (board[i][j] != '.') {
                    if (filled.contains(board[i][j])) {
                        return false;
                    }
                    filled.add(board[i][j]);
                }
            }
        }

        //check duplicates in columns
        for (int j = 0; j < n; j++) {
            Set<Character> filled = new HashSet<>();
            for (int i = 0; i < m; i++) {
                if (board[i][j] != '.') {
                    if (filled.contains(board[i][j])) {
                        return false;
                    }
                    filled.add(board[i][j]);
                }
            }
        }

        int i = 0;
        int j = 0;
        while (i < m && j < n) {
            Set<Character> filled = new HashSet<>();
            for (int p = i; p < i+3; p++) {
                for (int q = j; q < j+3; q++) {
                    if (board[p][q] != '.') {
                        if (filled.contains(board[p][q])) {
                            return false;
                        }
                        filled.add(board[p][q]);
                    }
                }
            }
            j = j+3;
            if (j == n) {
                i = i + 3;
                j = 0;
            }
        }

        return true;
    }
}
