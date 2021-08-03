package dynamicprogramming;

public class TilingWithDominoes {
    private static final int mod = 1000000007;

    public int solve(int A) {
        long[] a = new long[A + 1];
        long[] b = new long[A + 1];
        a[0] = 1;
        a[1] = 0;
        b[0] = 0;
        b[1] = 1;

        for (int i = 2; i <= A; i++) {
            a[i] = (a[i - 2] + 2 * b[i - 1]) % mod;
            b[i] = (a[i - 1] + b[i - 2]) % mod;
        }

        return (int)(a[A] % mod);
    }
}
