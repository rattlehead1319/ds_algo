package dynamicprogramming.medium;

public class DistinctOccurrences {
    int  subsequenceCount(String S, String T)
    {
        //return subsequenceCount(S, T, 0, "");
        return subsequenceCountDP(S, T);
    }

    int subsequenceCount(String s, String t, int index, String c) {
        if (c.equals(t)) {
            return 1;
        }
        if (c.length() > t.length()) {
            return 0;
        }

        int count = 0;
        for (int i = index; i < s.length(); i++) {
            count += subsequenceCount(s, t, i + 1, c + s.charAt(i));
        }
        return count;
    }

    int subsequenceCountDP (String s, String t) {

        int m = t.length();
        int n = s.length();

        int[][] dp = new int[m+1][n+1];

        for (int i = 0; i <= m; i++) {
            dp[i][0] = 0;
        }

        for (int i = 0; i <= n; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (t.charAt(i-1) != s.charAt(j-1)) {
                    dp[i][j] = dp[i][j-1] % 1000000007;
                } else {
                    dp[i][j] = (dp[i][j-1] + dp[i-1][j-1]) % 1000000007;
                }
            }
        }

        return dp[m][n] % 1000000007;
    }
}
