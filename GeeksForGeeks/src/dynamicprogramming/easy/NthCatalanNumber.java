package dynamicprogramming.easy;

import java.math.BigInteger;

public class NthCatalanNumber {
    public static BigInteger findCatalan(int n)
    {
        BigInteger[] dp = new BigInteger[2*n+1];
        dp[0] = new BigInteger("1");
        dp[1] = new BigInteger("1");
        dp[2] = new BigInteger("2");
        return factorial(2*n, dp).divide((factorial(n+1, dp).multiply(factorial(n, dp))));

    }

    private static BigInteger factorial (int n, BigInteger[] dp) {

        if (n == 1) {
            return new BigInteger("1");
        } else if (dp[n] != null && dp[n].compareTo(BigInteger.valueOf(0)) > 0) {
            return dp[n];
        }
        dp[n] = BigInteger.valueOf(n).multiply(factorial(n-1, dp));
        return dp[n];
    }
}
