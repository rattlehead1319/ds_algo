package dynamicprogramming.tutorials;

public class CountBSTWithNKeysDP {
    public static int countBST (int n) {
        int[] dp = new int[n+1];

        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[i-1-j] * dp[j];
            }
        }

        return dp[n];
    }

    public static void main (String[] args) {
        System.out.println(countBST(3));
    }
}
