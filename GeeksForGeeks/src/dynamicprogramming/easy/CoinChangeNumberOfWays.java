package dynamicprogramming.easy;

public class CoinChangeNumberOfWays {
    public long numberOfWays(int coins[],int numberOfCoins,int value)
    {
        //return numberOfWaysRecursive(coins, numberOfCoins, value);
        return numberOfWaysDP(coins, numberOfCoins, value);
    }

    private long numberOfWaysDP (int[] coins, int n, int sum) {
        long[][] dp = new long[sum+1][n+1];
        for (int i = 0; i <= n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 0; i <= sum; i++) {
            dp[i][0] = 0;
        }

        for (int i = 1; i <= sum; i++) {
            for (int j= 1; j <= n; j++) {
                dp[i][j] = dp[i][j-1];
                if (coins[j-1] <= i) {
                    dp[i][j] += dp[i - coins[j-1]][j];
                }
            }
        }
        return dp[sum][n];
    }

    private long numberOfWaysRecursive (int[] coins, int n, int sum) {
        if (sum == 0) {
            return 1;
        }
        if (n == 0) {
            return 0;
        }

        long x = numberOfWaysRecursive(coins, n-1, sum);
        if (coins[n-1] <= sum) {
            x += numberOfWaysRecursive(coins, n, sum - coins[n-1]);
        }
        return x;
    }
}
