package problems.hard.dynamicprogramming;

import java.util.*;

public class LongestIncreasingPath {
    class Cell {
        int x;
        int y;
        int value;
        Cell(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }
    }

    int[] rows = new int[]{0, -1, 0, 1};
    int[] cols = new int[]{-1, 0, 1, 0};

    public int longestIncreasingPath(int[][] matrix) {
        PriorityQueue<Cell> cells = new PriorityQueue<>((a,b) -> a.value - b.value);
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], Integer.MIN_VALUE);
            for (int j = 0; j < n; j++) {
                cells.add(new Cell(i, j, matrix[i][j]));
            }
        }

        int result = 0;
        while (!cells.isEmpty()) {
            Cell cell = cells.poll();
            int x = cell.x;
            int y = cell.y;
            dp[x][y] = Math.max(1, dp[x][y]);
            for (int i = 0; i < 4; i++) {
                int x1 = x + rows[i];
                int y1 = y + cols[i];
                if (x1 >= 0 && x1 < m && y1 >= 0 && y1 < n && matrix[x1][y1] > matrix[x][y]) {
                    dp[x1][y1] = Math.max(dp[x1][y1], dp[x][y] + 1);
                    result = Math.max(result, dp[x1][y1]);
                }
            }
            result = Math.max(result, dp[x][y]);
        }

        return result;
    }
}
