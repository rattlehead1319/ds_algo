package dynamicprogramming.tutorials;

public class AllocateMinNumberOfPagesRecursive {
    private static int minPages (int[] arr, int n, int k) {
        if (k == 1) {
            return sum(arr, 0, n-1);
        }
        if (n == 1) {
            return arr[0];
        }

        int res = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            int x = Math.max(minPages(arr, i, k-1), sum(arr, i, n-1));
            res = Math.min(res, x);
        }
        return res;
    }

    private static int sum (int[] arr, int i, int j) {
        int x = 0;
        while (i <= j) {
            x += arr[i++];
        }
        return x;
    }

    public static void main (String[] args) {
        System.out.println(minPages(new int[]{10, 20, 30, 40}, 4, 2));
        System.out.println(minPages(new int[]{10, 5, 30, 1, 2, 5, 10, 10}, 8, 3));
    }
}
