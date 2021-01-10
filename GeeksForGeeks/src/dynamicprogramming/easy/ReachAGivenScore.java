package dynamicprogramming.easy;

public class ReachAGivenScore {
    public static int count(int n)
    {
        int[] arr = new int[]{3, 5, 10};
        //return countRecursive(arr, 3, n);
        return countDP(arr, 3, n);
    }

    private static int countRecursive (int[] arr, int n, int sum) {
        if (sum == 0) {
            return 1;
        }
        if (n == 0) {
            return 0;
        }

        int x = countRecursive(arr, n-1, sum);
        if (arr[n-1] <= sum) {
            x += countRecursive(arr, n, sum - arr[n-1]);
        }
        return x;
    }

    private static int countDP (int[] arr, int n, int sum) {
        int[][] dp = new int[sum+1][n+1];

        for (int i = 0; i <= n; i++) {
            dp[0][i] = 1;
        }

        for (int i = 0; i<= sum; i++) {
            dp[i][0] = 0;
        }

        for (int i = 1; i <= sum; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i][j-1];
                if (arr[j-1] <= i) {
                    dp[i][j] += dp[i - arr[j-1]][j];
                }
            }
        }
        return dp[sum][n];
    }
}
