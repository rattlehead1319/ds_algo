package dynamicprogramming.tutorials;

public class SubsetSumDP {

    public static int subsetSum (int[] arr, int n, int sum) {
        int[][] dp = new int[sum+1][n+1];

        for (int i = 0; i <= n; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i <= sum; i++) {
            dp[i][0] = 0;
        }

        for (int i = 1; i <= sum; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i][j-1];
                if (arr[j-1] <= i) {
                    dp[i][j] += dp[i - arr[j-1]][j-1];
                }
            }
        }

        return dp[sum][n];
    }

    public static void main (String[] args) {
        System.out.println(subsetSum(new int[]{10, 20, 15}, 3, 25));
        System.out.println(subsetSum(new int[]{10, 5, 2, 3, 6}, 5, 8));
        System.out.println(subsetSum(new int[]{1, 2, 3}, 3, 4));
        System.out.println(subsetSum(new int[]{10, 20, 15}, 3, 37));
    }
}
