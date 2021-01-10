package dynamicprogramming.easy;

public class CountNumberOfHops {
    static long countWays(int n)
    {
        if (n == 1 || n == 2) {
            return Long.valueOf(n);
        }
        if (n == 3) {
            return 4;
        }

        long[] dp = new long[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 1 + dp[2] + dp[1];

        for (int i = 4; i <= n; i++) {
            dp[i] = (dp[i-1] + dp[i-2] + dp[i-3]) % 1000000007;
        }

        return dp[n] % 1000000007;
    }
}
