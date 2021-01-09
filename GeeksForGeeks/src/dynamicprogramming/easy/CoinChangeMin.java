package dynamicprogramming.easy;

public class CoinChangeMin {
    public long minimumNumberOfCoins(int coins[],int numberOfCoins,int value)
    {
        // long result = minimumNumberOfCoinsRecursive(coins, numberOfCoins, value);
        long result = minimumNumberOfCoinsDP(coins, numberOfCoins, value);
        if (result == Long.MAX_VALUE) {
            result = -1;
        }
        return result;
    }

    private long minimumNumberOfCoinsRecursive (int coins[],int numberOfCoins,int value) {
        if (value == 0) {
            return 0;
        }

        long result = Long.MAX_VALUE;
        for (int i = 0; i < numberOfCoins; i++) {
            if (coins[i] <= value) {
                long x = minimumNumberOfCoinsRecursive(coins, numberOfCoins, value - coins[i]);
                if (x != Long.MAX_VALUE) {
                    result = Math.min(result, 1 + x);
                }
            }
        }
        return result;
    }

    private long minimumNumberOfCoinsDP (int coins[],int numberOfCoins, int value) {

        long[] dp = new long[value+1];
        dp[0] = 0;

        for(int i = 1; i <= value; i++) {
            dp[i] = Long.MAX_VALUE;
        }

        for (int i = 1; i <= value; i++) {
            for (int j = 0; j < numberOfCoins; j++) {
                if (coins[j] <= i) {
                    long x = dp[i-coins[j]];
                    if (x != Long.MAX_VALUE) {
                        dp[i] = Math.min(dp[i], 1+x);
                    }
                }
            }
        }

        return dp[value];
    }
}
