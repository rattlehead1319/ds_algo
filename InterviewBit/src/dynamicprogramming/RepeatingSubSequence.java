package dynamicprogramming;

public class RepeatingSubSequence {
    public int anytwo(String A) {
        if (A == null || A.length() < 2) {
            return 0;
        }
        String B = A;
        return lcs(A, B);
    }

    private int lcs(String A, String B) {
        int m = A.length();
        int[][]dp = new int[m + 1][m + 1];

        int result = Integer.MIN_VALUE;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= m; j++) {
                if (i != j && A.charAt(i - 1) == B.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
                result = Math.max(result, dp[i][j]);
            }
        }
        return result >= 2 ? 1: 0;
    }
}
