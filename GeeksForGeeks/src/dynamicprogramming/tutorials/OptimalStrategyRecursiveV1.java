package dynamicprogramming.tutorials;

public class OptimalStrategyRecursiveV1 {

    public static int mainSolution (int[] arr) {
        int sum = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        return sol(arr, 0, n-1, sum);
    }

    private static int sol (int[] arr, int i, int j, int sum) {
        if (i+1 == j) {
            return Math.max(arr[i], arr[j]);
        }

        return Math.max(
                sum - sol(arr, i+1, j, sum - arr[i]),
                sum - sol(arr, i, j-1, sum - arr[j])
        );
    }

    public static void main (String[] args) {
        System.out.println(mainSolution(new int[]{20, 5, 4, 6}));
    }
}
