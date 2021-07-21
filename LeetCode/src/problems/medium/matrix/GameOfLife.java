package problems.medium.matrix;

public class GameOfLife {
    int[] rows = new int[]{0, -1, -1, -1, 0, 1, 1, 1};
    int[] cols = new int[]{-1, -1, 0, 1, 1, 1, 0, -1};

    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;

        int[][] nextBoard = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int ones = 0;
                for (int z = 0; z < 8; z++) {
                    int nextRow = i + rows[z];
                    int nextCol = j + cols[z];

                    if (nextRow >= 0 && nextRow < m && nextCol >= 0 && nextCol < n && board[nextRow][nextCol] == 1) {
                        ones++;
                    }
                }
                //Rule 1: Any live cell with fewer than two live neighbors dies as if caused by under-population.
                if (board[i][j] == 1 && ones < 2) {
                    nextBoard[i][j] = 0;
                }
                //Rule 2: Any live cell with two or three live neighbors lives on to the next generation.
                else if (board[i][j] == 1 && (ones == 2 || ones == 3)) {
                    nextBoard[i][j] = 1;
                }
                //Rule 3: Any live cell with more than three live neighbors dies, as if by over-population.
                else if (board[i][j] == 1 && ones > 3) {
                    nextBoard[i][j] = 0;
                }
                //Rule 4: Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction
                else if (board[i][j] == 0 && ones == 3) {
                    nextBoard[i][j] = 1;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = nextBoard[i][j];
            }
        }
    }
}
