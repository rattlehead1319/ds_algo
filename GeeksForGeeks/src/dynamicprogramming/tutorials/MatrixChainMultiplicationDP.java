package dynamicprogramming.tutorials;

public class MatrixChainMultiplicationDP {

    public static int minMultiplication (int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n];

        for (int i = 1; i < n-1; i++) {
            dp[i][i+1] = 0;
        }

        for (int gap = 2; gap < n; gap++) {
            for (int i = 0; i + gap < n; i++) {
                int j = i + gap;
                dp[i][j] = Integer.MAX_VALUE;

                for (int k = i+1; k < j; k++) {
                    int x = dp[i][k] + dp[k][j] + arr[i]*arr[k]*arr[j];
                    dp[i][j] = Math.min(dp[i][j], x);
                }
            }
        }

        return dp[0][n-1];
    }

    public static void main (String[] args) {
        System.out.println(minMultiplication(new int[]{2,1,3,4}));
        System.out.println(minMultiplication(new int[]{2,1,3}));
    }
}
