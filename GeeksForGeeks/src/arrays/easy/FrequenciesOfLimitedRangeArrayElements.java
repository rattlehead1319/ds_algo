package arrays.easy;

public class FrequenciesOfLimitedRangeArrayElements {
    public static void frequencycount(int arr[], int n)
    {
        for (int i = 0; i < n; i++) {
            arr[i] = arr[i]-1;
        }

        for (int i = 0; i < n; i++) {
            arr[arr[i]%n] = arr[arr[i]%n] + n;
        }

        for (int i = 0; i < n; i++) {
            arr[i] = arr[i]/n;
        }
    }
}
