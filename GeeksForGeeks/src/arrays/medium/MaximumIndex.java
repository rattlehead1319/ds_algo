package arrays.medium;

public class MaximumIndex {
    static int maxIndexDiff(int arr[], int n) {

        int[] lmin = new int[n];
        lmin[0] = arr[0];
        for (int i = 1; i < n; i++) {
            lmin[i] = Math.min(lmin[i-1], arr[i]);
        }

        int[] rmax = new int[n];
        rmax[n-1] = arr[n-1];
        for (int j = n-2; j >= 0; j--) {
            rmax[j] = Math.max(arr[j], rmax[j+1]);
        }

        int i = 0;
        int j = 0;
        int max = Integer.MIN_VALUE;
        while (i < n && j < n) {
            if (lmin[i] <= rmax[j]) {
                max = Math.max(max, j-i);
                j++;
            } else {
                i++;
            }
        }
        return max;
    }
}
