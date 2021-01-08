package dynamicprogramming.tutorials;

public class OptimalStrategyRecursiveV2 {

    public static int mainSol (int[] arr) {
        return sol(arr, 0, arr.length-1);
    }

    public static int sol (int[] arr, int i, int j) {
        if (i+1 == j) {
            return Math.max(arr[i], arr[j]);
        }

        return Math.max(
                arr[i] + Math.min(
                        sol(arr, i+2, j),
                        sol(arr, i+1, j-1)
                ),
                arr[j] + Math.min(
                        sol(arr, i+1, j-1),
                        sol(arr, i, j-2)
                )
        );
    }

    public static void main (String[] args) {
        System.out.println(mainSol(new int[]{20, 5, 4, 6}));
    }
}
