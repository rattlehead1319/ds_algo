package dynamicprogramming.tutorials;

public class AllocateMinNumberOfPagesDP {
    public static int minPages (int[] arr, int n, int k) {
        int[][] dp = new int[k+1][n+1];

        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += arr[i-1];
            dp[1][i] = sum;
        }

        for (int i = 1; i <= k; i++) {
            dp[i][1] = arr[0];
        }

        for (int i = 2; i <= k; i++) {
            for (int j = 2; j <= n; j++) {
                int res = Integer.MAX_VALUE;
                for (int t = 1; t < j; t++) {
                    int x = Math.max(dp[i-1][t], getSum(arr, t, j-1));
                    res = Math.min(res, x);
                }
                dp[i][j] = res;
            }
        }
        return dp[k][n];
    }

    private static int getSum(int[] arr, int t, int i) {
        int sum = 0;
        while (t <= i) {
            sum += arr[t++];
        }
        return sum;
    }

    public static void main (String[] args) {
        System.out.println(minPages(new int[]{10, 20, 30, 40}, 4, 2));
        System.out.println(minPages(new int[]{10, 5, 30, 1, 2, 5, 10, 10}, 8, 3));
    }
}
