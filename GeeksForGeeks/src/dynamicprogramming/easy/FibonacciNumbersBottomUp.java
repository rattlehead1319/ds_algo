package dynamicprogramming.easy;

public class FibonacciNumbersBottomUp {
    public long findNthFibonacci(int number)
    {
        long[] dp = new long[number+1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= number; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[number];
    }
}
