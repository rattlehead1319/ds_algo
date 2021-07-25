package problems.hard.dynamicprogramming;

public class CountVowelPermutations {
    public int countVowelPermutation(int n) {
        long[][] dp = new long[n+1][5];

        if (n == 1) {
            return 5;
        }

        for (int j = 0; j < 5; j++) {
            dp[1][j] = 1;
        }

        dp[2][0] = 1;
        dp[2][1] = 2;
        dp[2][2] = 4;
        dp[2][3] = 2;
        dp[2][4] = 1;

        for (int i = 3; i <= n; i++) {
            dp[i][0] = dp[i-1][1] % 1000000007;
            dp[i][1] = (dp[i-1][0] + dp[i-1][2]) % 1000000007;
            dp[i][2] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][3] + dp[i-1][4]) % 1000000007;
            dp[i][3] = (dp[i-1][2] + dp[i-1][4]) % 1000000007;
            dp[i][4] = dp[i-1][0] % 1000000007;
        }

        long result = 0;
        for (int j = 0; j < 5; j++) {
            result += (long)dp[n][j] % 1000000007;
        }

        return (int)(result % 1000000007);
    }
}
