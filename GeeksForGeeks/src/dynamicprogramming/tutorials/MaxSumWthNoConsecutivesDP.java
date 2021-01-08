package dynamicprogramming.tutorials;

public class MaxSumWthNoConsecutivesDP {

    public static int maxSum (int[] arr) {
        int n = arr.length;

        if (n == 1) {
            return arr[0];
        }

        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = arr[0];
        dp[2] = Math.max(arr[0], arr[1]);

        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(arr[i-1] + dp[i-2], dp[i-1]);
        }
        return dp[n];
    }

    public static void main (String[] args) {
        System.out.println(maxSum(new int[]{10, 5, 15, 20, 2, 30}));
        System.out.println(maxSum(new int[]{8, 7, 6, 10}));
        System.out.println(maxSum(new int[]{1, 10, 2}));
    }
}
