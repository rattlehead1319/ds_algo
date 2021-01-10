package dynamicprogramming.medium;

public class MaxSubArrayByRemovingAtMostOneElement {
    public static int maxSumSubarray(int A[], int n)
    {
        int[] dp = new int[n];
        dp[0] = A[0];

        int max = A[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(A[i], A[i] + dp[i-1]);
            max = Math.max(max, dp[i]);
        }

        int[] dpb = new int[n];

        dpb[n-1] = A[n-1];
        for (int i = n-2; i >= 0; i--) {
            dpb[i] = Math.max(A[i], A[i] + dpb[i+1]);
            max = Math.max(max, dpb[i]);
        }

        for (int i = 1; i < n-1; i++) {
            max = Math.max(max, dp[i-1] + dpb[i+1]);
        }

        return max;
    }
}
