package dynamicprogramming.tutorials;

public class OptimalStrategyDP {

    public static int mainSolution (int[] arr) {

        int n = arr.length;
        int[][] dp = new int[n][n];

        for (int i = 0; i < n-1; i++) {
            dp[i][i+1] = Math.max(arr[i], arr[i+1]);
        }

        for (int gap = 3; gap < n; gap = gap+2) {
            for (int i = 0; i+gap < n; i++) {
                int j = i+gap;
                dp[i][j] = Math.max(
                    arr[i] + Math.min(dp[i+2][j], dp[i+1][j-1]),
                    arr[j] + Math.min(dp[i+1][j-1], dp[i][j-2])
                );
            }
        }

        return dp[0][n-1];
    }

    public static void main (String[] args) {
        System.out.println(mainSolution(new int[]{20, 5, 4, 6}));
    }
}
