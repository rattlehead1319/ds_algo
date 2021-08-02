package dynamicprogramming;

public class WaysToDecode {
    private final static int mod = 1000000007;

    public int numDecodings(String A) {
        int n = A.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = A.charAt(0) == '0' ? 0 : 1;

        for (int i = 2; i <= n; i++) {
            int singleDigit = Integer.parseInt(A.substring(i - 1, i));
            if (singleDigit >= 1) {
                dp[i] += dp[i - 1] % mod;
            }
            int doubleDigit = Integer.parseInt(A.substring(i - 2, i));
            if (doubleDigit >= 10 && doubleDigit <= 26) {
                dp[i] += dp[i - 2] % mod;
            }
        }

        return dp[n] % mod;
    }
}
