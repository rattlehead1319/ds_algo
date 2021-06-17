package problems.medium.dp;

public class UniquePaths2 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int [m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0 && obstacleGrid[i][j] != 1) {
                    dp[i][j] = 1;
                    continue;
                }
                int fromLeft = (j-1 >= 0 && obstacleGrid[i][j-1] != 1) ? dp[i][j-1] : 0;
                int fromTop = (i-1 >= 0 && obstacleGrid[i-1][j] != 1) ? dp[i-1][j] : 0;
                dp[i][j] = obstacleGrid[i][j] != 1 ? fromLeft + fromTop : 0;
            }
        }

        return dp[m-1][n-1];
    }
}
