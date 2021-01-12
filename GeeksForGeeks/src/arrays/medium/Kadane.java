package arrays.medium;

public class Kadane {
    int maxSubarraySum(int arr[], int n){

        int[] dp = new int[n];
        dp[0] = arr[0];

        int max = dp[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(arr[i], arr[i] + dp[i-1]);
            max = Math.max(max, dp[i]);
        }

        return max;
    }
}
