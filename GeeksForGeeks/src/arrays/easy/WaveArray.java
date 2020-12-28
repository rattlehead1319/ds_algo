package arrays.easy;

public class WaveArray {
    public static void convertToWave(int arr[], int n){

        for (int i = 1; i < n; i = i+2) {
            int temp = arr[i];
            arr[i] = arr[i-1];
            arr[i-1] = temp;
        }

    }
}
