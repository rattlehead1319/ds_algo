package dynamicprogramming.easy;

public class KadanesAlgorithm2 {
    public long maximumSum(int arr[], int sizeOfArray)
    {
        int[] dp = new int[sizeOfArray];
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0], arr[1]);

        int max = Math.max(dp[0], dp[1]);
        for (int i = 2; i < sizeOfArray; i++) {
            dp[i] = Math.max(arr[i], arr[i] + dp[i-2]);
            dp[i] = Math.max(dp[i], dp[i-1]);
            max = Math.max(max, dp[i]);
        }
        return Long.valueOf(max);
    }
}
