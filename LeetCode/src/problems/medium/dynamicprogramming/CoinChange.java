package problems.medium.dynamicprogramming;


import java.util.Arrays;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {

        //return coinChangeRecursive(coins, amount);
        int x = coinChangeDP(coins, amount);
        return x == Integer.MAX_VALUE ? -1 : x;
    }

    private int coinChangeRecursive(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }

        int result = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            if (coins[i] <= amount) {
                int x = coinChangeRecursive(coins, amount - coins[i]);
                if (x != Integer.MAX_VALUE) {
                    result = Math.min(result, 1 + x);
                }
            }
        }

        return result;
    }

    private int coinChangeDP(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    int x = dp[i - coins[j]];
                    if (x != Integer.MAX_VALUE) {
                        dp[i] = Math.min(dp[i], 1 + x);
                    }
                }
            }
        }

        return dp[amount];
    }
}
