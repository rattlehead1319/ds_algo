package problems.medium.matrix;

import java.util.*;

public class TicTacToe {
    int[][] matrix;

    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        matrix = new int[n][n];
        for (int[] arr: matrix) {
            Arrays.fill(arr, -1);
        }
    }

    /** Player {player} makes a move at ({row}, {col}).
     @param row The row of the board.
     @param col The column of the board.
     @param player The player, can be either 1 or 2.
     @return The current winning condition, can be either:
     0: No one wins.
     1: Player 1 wins.
     2: Player 2 wins. */
    public int move(int row, int col, int player) {
        matrix[row][col] = player;
        int n = matrix.length;

        int i = -1;

        //check for row
        for (i = 0; i < n; i++) {
            if (matrix[i][col] != player) {
                break;
            }
        }
        if (i == n) {
            return player;
        }

        //check for column
        for (i = 0; i < n; i++) {
            if (matrix[row][i] != player) {
                break;
            }
        }
        if (i == n) {
            return player;
        }

        //check for diagonal
        i = 0;
        int j = 0;
        while (i < n && j < n) {
            if (matrix[i][j] != player) {
                break;
            }
            i++;
            j++;
        }
        if (i == n) {
            return player;
        }

        //check for other diagonal
        i = 0;
        j = n-1;
        while (i < n && j >= 0) {
            if (matrix[i][j] != player) {
                break;
            }
            i++;
            j--;
        }
        if (i == n) {
            return player;
        }

        return 0;
    }
}
