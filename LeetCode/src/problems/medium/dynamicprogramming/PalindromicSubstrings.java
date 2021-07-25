package problems.medium.dynamicprogramming;

public class PalindromicSubstrings {
    public int countSubstrings(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        int result = 0;

        //for string length 1
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
            result++;
        }

        //for string length 2
        for (int i = 0; i < n - 1; i++) {
            dp[i][i+1] = s.charAt(i) == s.charAt(i+1);
            result += dp[i][i+1] ? 1 : 0;
        }

        //for string length 3 and above
        for (int k = 3; k <= n; k++) {
            int i = 0;
            for (int j = i + k - 1; j < n; j++) {
                dp[i][j] = dp[i+1][j-1] && s.charAt(i) == s.charAt(j);
                result += dp[i][j] ? 1 : 0;
                i++;
            }
        }

        return result;
    }
}
