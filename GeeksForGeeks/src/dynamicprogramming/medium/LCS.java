package dynamicprogramming.medium;

public class LCS {
    static int lcs(int p, int q, String s1, String s2){

        //return lcsRecursive(s1, s2, p, q);
        return lcsDP(s1, s2, p, q);
    }

    static int lcsRecursive (String s1, String s2, int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }

        if (s1.charAt(m-1) == s2.charAt(n-1)) {
            return 1 + lcsRecursive(s1, s2, m-1, n-1);
        }

        return Math.max(
                lcsRecursive(s1, s2, m-1, n),
                lcsRecursive(s1, s2, m, n-1)
        );
    }

    static int lcsDP(String s1, String s2, int m, int n) {
        int[][] dp = new int[m+1][n+1];

        for (int i = 0; i <= m; i++) {
            dp[i][0] = 0;
        }

        for (int j = 0; j <= n; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }

        return dp[m][n];
    }
}
