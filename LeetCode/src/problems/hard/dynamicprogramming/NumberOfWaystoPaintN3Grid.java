package problems.hard.dynamicprogramming;

public class NumberOfWaystoPaintN3Grid {
    public int numOfWays(int n) {
        long a121 = 6;
        long a123 = 6;
        long b121;
        long b123;

        for (int i = 1; i < n; i++) {
            b121 = a121 * 3 + a123 * 2;
            b123 = a121 * 2 + a123 * 2;
            a121 = b121 % 1000000007;
            a123 = b123 % 1000000007;
        }

        return (int)(a121 + a123) % 1000000007;
    }
}
