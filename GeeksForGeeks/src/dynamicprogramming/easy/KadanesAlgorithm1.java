package dynamicprogramming.easy;

public class KadanesAlgorithm1 {
    public long maximumSum(int arr[], int sizeOfArray)
    {
        int[] dp = new int[sizeOfArray];
        dp[0] = arr[0];
        for (int i = 1; i < sizeOfArray; i++) {
            dp[i] = Math.max(arr[i], arr[i]+dp[i-1]);
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < sizeOfArray; i++) {
            System.out.print(dp[i] + " ");
            max = Math.max(max, dp[i]);
        }
        System.out.println();
        return max;
    }
}
