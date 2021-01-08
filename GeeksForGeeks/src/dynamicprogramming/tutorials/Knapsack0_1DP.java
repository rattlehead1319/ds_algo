package dynamicprogramming.tutorials;

public class Knapsack0_1DP {

    public static int knapsack (int[] v, int[] w, int W, int n) {

        int[][] dp = new int[W+1][n+1];

        for (int i = 0; i <= W; i++) {
            dp[i][0] = 0;
        }

        for (int i = 0; i <= n; i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i <= W; i++) {
            for (int j = 1; j <= n; j++) {
                if (w[j-1] > i) {
                    dp[i][j] = dp[i][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i][j-1], v[j-1] + dp[i - w[j-1]][j-1]);
                }
            }
        }
        return dp[W][n];
    }

    public static void main (String[] args) {
        System.out.println(knapsack(new int[]{10, 40, 30, 50}, new int[]{5, 4, 6, 3}, 10, 4));
    }
}
