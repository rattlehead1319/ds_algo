package dynamicprogramming.medium;

public class MinNumberOfJumps {
    public static int minimumJumps(int arr[], int n){

        //int x = minimumJumpsRec(arr, n);
        int x = minimumJumpsDP(arr, n);
        if (x == Integer.MAX_VALUE) {
            return -1;
        }
        return x;
    }

    private static int minimumJumpsRec(int[] arr, int n) {
        if (n == 1) {
            return 0;
        }

        int res = Integer.MAX_VALUE;
        for (int i = n-2; i >= 0; i--) {
            if (arr[i] >= n-i-1) {
                int x = minimumJumpsRec(arr, i+1);
                if (x != Integer.MAX_VALUE) {
                    res = Math.min(res, 1 + x);
                }
            }
        }
        return res;
    }

    private static int minimumJumpsDP(int[] arr, int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 0;

        for (int i = 2; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] >= i-j-1) {
                    int x = dp[j+1];
                    if (x != Integer.MAX_VALUE) {
                        dp[i] = Math.min(dp[i], 1 + x);
                    }
                }
            }
        }
        return dp[n];
    }
}
