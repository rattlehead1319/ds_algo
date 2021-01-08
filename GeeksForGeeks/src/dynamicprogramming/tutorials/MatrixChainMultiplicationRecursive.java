package dynamicprogramming.tutorials;

public class MatrixChainMultiplicationRecursive {

    public static int minMultiplication (int[] arr, int i, int j) {

        if (i + 1 == j) {
            return 0;
        }

        int res = Integer.MAX_VALUE;
        for (int k = i+1; k < j; k++) {
            int x = minMultiplication(arr, i, k) +
                    minMultiplication(arr, k, j) +
                    arr[i]*arr[k]*arr[j];

            res = Math.min(res, x);
        }

        return res;
    }

    public static void main (String[] args) {
        System.out.println(minMultiplication(new int[]{2,1,3,4}, 0, 3));
        System.out.println(minMultiplication(new int[]{2,1,3}, 0, 2));
    }
}
