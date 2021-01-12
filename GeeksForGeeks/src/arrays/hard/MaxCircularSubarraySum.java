package arrays.hard;

public class MaxCircularSubarraySum {
    static int circularSubarraySum(int a[], int n) {
        boolean allPositives = true;
        boolean allNegatives = true;
        for (int i = 0; i < n; i++) {
            if (a[i] > 0) {
                allNegatives = false;
            }
            if (a[i] < 0) {
                allPositives = false;
            }
        }
        if (allPositives || allNegatives) {
            return kadane(a, n);
        }
        return Integer.max(kadane(a,n), reverseKadane(a,n));
    }

    static int kadane(int[] arr, int n) {
        int[] dp = new int[n];
        dp[0] = arr[0];

        int max = dp[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(arr[i], arr[i] + dp[i-1]);
            max = Math.max(max, dp[i]);
        }

        return max;
    }

    static int reverseKadane (int[] arr, int n) {

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            arr[i] = -1 * arr[i];
        }
        int rk = kadane(arr, n);
        return sum + rk;
    }
}
