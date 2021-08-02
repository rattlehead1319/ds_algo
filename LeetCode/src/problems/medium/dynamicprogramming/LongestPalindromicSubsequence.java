package problems.medium.dynamicprogramming;

public class LongestPalindromicSubsequence {
    public int longestPalindromeSubseq(String s) {
        if (s.length() <= 1) {
            return s.length();
        }
        String s1 = new StringBuilder(s).reverse().toString();
        return lcs(s, s1);
    }

    private int lcs(String s1, String s2) {
        int n = s1.length();
        int[][] dp = new int[n+1][n+1];
        int result = Integer.MIN_VALUE;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
                result = Math.max(result, dp[i][j]);
            }
        }

        return result;
    }
}
