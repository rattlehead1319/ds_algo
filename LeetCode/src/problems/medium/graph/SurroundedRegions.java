package problems.medium.graph;

import java.util.*;

public class SurroundedRegions {
    class Solution {

        int[] rows = new int[]{0, -1, 0, 1};
        int[] cols = new int[]{-1, 0, 1, 0};

        public void solve(char[][] board) {
            int m = board.length;
            int n = board[0].length;

            int[][] marked = new int[m][n];
            Queue<int[]> queue = new LinkedList<>();

            for (int i = 0; i < m; i++) {
                if (board[i][0] == 'O') {
                    marked[i][0] = 1;
                    queue.add(new int[]{i, 0});
                }
                if (board[i][n-1] == 'O') {
                    marked[i][n-1] = 1;
                    queue.add(new int[]{i, n-1});
                }
            }

            for (int j = 0; j < n; j++) {
                if (board[0][j] == 'O') {
                    marked[0][j] = 1;
                    queue.add(new int[]{0, j});
                }
                if (board[m-1][j] == 'O') {
                    marked[m-1][j] = 1;
                    queue.add(new int[]{m-1, j});
                }
            }

            boolean[][] visited = new boolean[m][n];

            while (!queue.isEmpty()) {
                int[] cell = queue.poll();
                int x = cell[0];
                int y = cell[1];
                visited[x][y] = true;

                for (int i = 0; i < 4; i++) {
                    int x1 = x + rows[i];
                    int y1 = y + cols[i];
                    if (x1 >= 0 && x1 < m && y1 >= 0 && y1 < n && !visited[x1][y1] && board[x1][y1] == 'O') {
                        marked[x1][y1] = 1;
                        queue.add(new int[]{x1, y1});
                    }
                }
            }

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (marked[i][j] != 1 && board[i][j] == 'O') {
                        board[i][j] = 'X';
                    }
                }
            }
        }
    }
}
