package dynamicprogramming.medium;

public class CountWaysToReachNthStair {
    Long countWays(int m){

        if (m == 1 || m == 2) {
            return Long.valueOf(m);
        }

        long[] dp = new long[m+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= m; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % 1000000007;
        }
        return dp[m] % 1000000007;
    }
}
