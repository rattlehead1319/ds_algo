package dynamicprogramming.tutorials;

public class MaxSumWthNoConsecutivesRecursive {

    public static int maxSum (int[] arr, int n) {

        if (n <= 0) {
            return 0;
        }

        if (n == 1) {
            return arr[0];
        }

        return Math.max (
                arr[n-1] + maxSum(arr, n-2),
                maxSum(arr, n-1)
        );
    }

    public static void main (String[] args) {
        System.out.println(maxSum(new int[]{10, 5, 15, 20, 2, 30}, 6));
        System.out.println(maxSum(new int[]{8, 7, 6, 10}, 4));
        System.out.println(maxSum(new int[]{1, 10, 2}, 3));
    }
}
