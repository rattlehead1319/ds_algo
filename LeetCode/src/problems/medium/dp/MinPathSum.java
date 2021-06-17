package problems.medium.dp;

public class MinPathSum {
    public int minPathSum(int[][] grid) {
        //Helper h = new Helper();
        //minPathSumRec(grid, 0, 0, 0, h);
        //return h.minSum;
        return minPathSumDP(grid);
    }

    private void minPathSumRec(int[][] grid, int i, int j, int sum, Helper h) {
        if (i == grid.length - 1 && j == grid[0].length - 1) {
            h.minSum = Math.min(h.minSum, sum + grid[i][j]);
            return;
        }
        if (i == grid.length || j == grid[0].length) {
            return;
        }

        minPathSumRec(grid, i+1, j, sum + grid[i][j], h);
        minPathSumRec(grid, i, j+1, sum + grid[i][j], h);
    }

    static class Helper {
        int minSum = Integer.MAX_VALUE;
    }

    private int minPathSumDP(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j != 0) {
                    grid[i][j] = grid[i][j] + grid[i][j-1];
                } else if (j == 0 && i != 0) {
                    grid[i][j] = grid[i][j] + grid[i-1][j];
                } else if (i > 0 && j > 0) {
                    grid[i][j] = grid[i][j] + Math.min(grid[i][j-1], grid[i-1][j]);
                }

            }
        }

        return grid[m-1][n-1];
    }
}
