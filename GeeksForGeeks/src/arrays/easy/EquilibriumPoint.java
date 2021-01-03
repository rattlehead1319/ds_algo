package arrays.easy;

public class EquilibriumPoint {
    public static int equilibriumPoint(long arr[], int n) {

        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }

        long leftSum = 0;
        for (int i = 0; i < n; i++) {
            if (sum - arr[i] == leftSum) {
                return i+1;
            }
            leftSum += arr[i];
            sum -= arr[i];
        }

        return -1;
    }
}
