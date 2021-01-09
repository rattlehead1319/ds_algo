package dynamicprogramming.easy;

public class WaysToWriteNSum {
    int countWays(int n){

        int[] arr = new int[n-1];
        for (int i = 0; i < n-1; i++) {
            arr[i] = i+1;
        }
        //return countWaysRecursive(arr, n-1, n);
        int x = countWaysDP(arr, n-1, n);
        x = x % 1000000007;
        return x;
    }

    int countWaysRecursive (int[] arr, int n, int sum) {
        if (sum == 0) {
            return 1;
        }

        if (n == 0) {
            return 0;
        }

        int x = countWaysRecursive(arr, n-1, sum);
        if (arr[n-1] <= sum) {
            x += countWaysRecursive(arr, n, sum - arr[n-1]);
        }

        return x;
    }

    int countWaysDP (int[] arr, int n, int sum) {
        int[][] dp = new int[sum+1][n+1];
        for (int i = 0; i<= n; i++) {
            dp[0][i] = 1;
        }

        for (int i = 0; i <= sum; i++) {
            dp[i][0] = 0;
        }

        for (int i = 1; i <= sum; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i][j-1] % 1000000007;
                if (arr[j-1] <= i) {
                    dp[i][j] += dp[i-arr[j-1]][j] % 1000000007;
                }
            }
        }
        return dp[sum][n];
    }
}
