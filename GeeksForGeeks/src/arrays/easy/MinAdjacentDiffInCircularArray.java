package arrays.easy;

public class MinAdjacentDiffInCircularArray {
    public static int minAdjDiff(int arr[], int n) {

        int min = Math.abs(arr[n-1] - arr[0]);
        for (int i = 1; i < n; i++) {
            min = Math.min(min, Math.abs(arr[i] - arr[i-1]));
        }
        return min;
    }
}
