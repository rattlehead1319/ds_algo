package dynamicprogramming.tutorials;

public class MinimumCoins {
    public static int minCoins (int[] coins, int n, int sum) {

        if (sum == 0) {
            return 0;
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (coins[i] <= sum) {
                int sub = minCoins(coins, n, sum - coins[i]);
                if (sub != Integer.MAX_VALUE) {
                    res = Math.min(sub + 1, res);
                }
            }
        }

        return res;
    }

    public static long minimumNumberOfCoins(int coins[],int numberOfCoins,int value)
    {
        if (value == 0) {
            return 0;
        }

        long result = Long.MAX_VALUE;
        for (int i = 0; i < numberOfCoins; i++) {
            if (coins[i] <= value) {
                long x = minimumNumberOfCoins(coins, numberOfCoins, value - coins[i]);
                if (x != Long.MAX_VALUE) {
                    result = Math.min(result, 1 + x);
                }
            }
        }
        return result;
    }

    public static void main (String[] args) {
        System.out.println(minCoins(new int[]{25, 10, 5}, 3, 30));
        System.out.println(minCoins(new int[]{3, 6, 3}, 3, 5));
        System.out.println(minCoins(new int[]{2, 5, 3, 6}, 4, 10));

        System.out.println(minimumNumberOfCoins(new int[]{25, 10, 5}, 3, 30));
        System.out.println(minimumNumberOfCoins(new int[]{3, 6, 3}, 3, 5));
        System.out.println(minimumNumberOfCoins(new int[]{2, 5, 3, 6}, 4, 10));
    }
}
