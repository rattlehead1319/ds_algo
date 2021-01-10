package dynamicprogramming.easy;

public class ShortestCommonSupersequence {
    public static int shortestCommonSupersequence(String X, String Y, int m, int n)
    {
        int[][] dp = new int[m+1][n+1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (X.charAt(i-1) == Y.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }

        int lcs = dp[m][n];
        int result = lcs + (X.length() - lcs) + (Y.length() - lcs);

        return result;
    }
}
