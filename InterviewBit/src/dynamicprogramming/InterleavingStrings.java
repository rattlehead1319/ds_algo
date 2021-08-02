package dynamicprogramming;

public class InterleavingStrings {
    public int isInterleave(String A, String B, String C) {
        int m = A.length();
        int n = B.length();
        if (C.length() != m + n) {
            return 0;
        }

        boolean[][] dp = new boolean[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if (i == 0) {
                    dp[i][j] = dp[i][j - 1] && B.charAt(j - 1) == C.charAt(i + j - 1);
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j] && A.charAt(i - 1) == C.charAt(i + j - 1);
                } else {
                    dp[i][j] = (dp[i][j - 1] && B.charAt(j - 1) == C.charAt(i + j - 1)) ||
                            (dp[i - 1][j] && A.charAt(i - 1) == C.charAt(i + j - 1));
                }
            }
        }

        return dp[m][n] ? 1 : 0;
    }
}
