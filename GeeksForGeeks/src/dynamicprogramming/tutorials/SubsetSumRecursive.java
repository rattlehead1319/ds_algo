package dynamicprogramming.tutorials;

public class SubsetSumRecursive {

    public static int subsetSum(int[] arr, int n, int sum) {
        if (sum == 0) {
            return 1;
        }

        if (n == 0) {
            return 0;
        }

        int x = subsetSum(arr, n-1, sum);
        if (arr[n-1] <= sum) {
            x += subsetSum(arr, n - 1, sum - arr[n - 1]);
        }

        return x;
    }

    public static void main (String[] args) {
        System.out.println(subsetSum(new int[]{10, 20, 15}, 3, 25));
        System.out.println(subsetSum(new int[]{10, 5, 2, 3, 6}, 5, 8));
        System.out.println(subsetSum(new int[]{1, 2, 3}, 3, 4));
        System.out.println(subsetSum(new int[]{10, 20, 15}, 3, 37));
    }
}
