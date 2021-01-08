package dynamicprogramming.tutorials;

public class MaximumCutsRecursive {
    public static int maxCuts (int n, int a, int b, int c) {

        if (n < 0) {
            return -1;
        }

        if (n == 0) {
            return 0;
        }

        int res = Math.max(
                maxCuts(n-a, a, b, c),
                Math.max(maxCuts(n-b, a, b, c),
                         maxCuts(n-c, a, b, c)
                )
        );

        if (res == -1) {
            return res;
        }
        return 1 + res;
    }

    public static void main (String[] args) {
        System.out.println(maxCuts(5, 1, 2, 3));
    }
}
