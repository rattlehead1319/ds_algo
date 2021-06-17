package problems.medium.dp;

public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                    continue;
                }
                int prevLeft = j-1 >= 0 ? dp[i][j-1] : 0;
                int prevTop = i-1 >= 0 ? dp[i-1][j] : 0;
                dp[i][j] = prevLeft + prevTop;
            }
        }
        return dp[m-1][n-1];
    }
}
