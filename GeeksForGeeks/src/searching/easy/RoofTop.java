package searching.easy;

public class RoofTop {
    static int maxStep(int arr[], int N){

        // Your code here
        int maxStep = Integer.MIN_VALUE;
        int step = 0;
        for (int i = 1; i < N; i++) {
            if (arr[i] > arr[i-1]) {
                step++;
            } else {
                maxStep = Math.max(maxStep, step);
                step = 0;
            }
        }
        maxStep = Math.max(maxStep, step);
        return maxStep;
    }
}
