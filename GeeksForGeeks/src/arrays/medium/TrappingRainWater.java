package arrays.medium;

public class TrappingRainWater {
    static int trappingWater(int arr[], int n) {


        int[] lmax = new int[n];
        int max = arr[0];
        lmax[0] = max;
        for (int i = 1; i < n; i++) {
            lmax[i] = Math.max(arr[i], lmax[i-1]);
        }

        int[] rmax = new int[n];
        max = arr[n-1];
        rmax[n-1] = max;
        for (int i = n-2; i >= 0; i--) {
            rmax[i] = Math.max(arr[i], rmax[i+1]);
        }

        int water = 0;
        for (int i = 0; i < n; i++) {
            water += Math.min(lmax[i], rmax[i]) - arr[i];
        }

        return water;
    }
}
