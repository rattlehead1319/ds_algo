package dynamicprogramming.tutorials;

public class MinimumCoinsDP {
    public static int getMin (int[] coins, int n, int sum) {
        int[] dp = new int[sum+1];
        dp[0] = 0;

        for (int i = 1; i <= sum; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                if (coins[j] <= i) {
                    int val = dp[i-coins[j]];
                    if (val != Integer.MAX_VALUE) {
                        dp[i] = Math.min(dp[i], 1 + val);
                    }
                }
            }
        }

        return dp[sum];
    }

    public static void main (String[] args) {
        System.out.println(getMin(new int[]{25, 10, 5}, 3, 30));
    }
}
