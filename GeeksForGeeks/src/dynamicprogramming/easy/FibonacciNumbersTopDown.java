package dynamicprogramming.easy;

public class FibonacciNumbersTopDown {
    public long findNthFibonacci(int number, long dp[])
    {
        if (number == 0) {
            return 0;
        }
        if (dp[number] != 0) {
            return dp[number];
        }
        dp[number] = findNthFibonacci(number-1, dp) + findNthFibonacci(number-2, dp);
        return dp[number];
    }
}
