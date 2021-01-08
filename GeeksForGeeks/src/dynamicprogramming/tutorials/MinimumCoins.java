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

    public static void main (String[] args) {
        System.out.println(minCoins(new int[]{25, 10, 5}, 3, 30));
    }
}
