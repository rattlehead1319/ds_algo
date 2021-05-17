package arrays.medium;

public class RearrangeArrayAlternatively {
    public static void rearrange(int arr[], int n){

        int maxElement = arr[n-1] + 1;

        int maxIndex = n-1;
        int minIndex = 0;

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                arr[i] += (arr[maxIndex] % maxElement) * maxElement;
                maxIndex--;
            } else {
                arr[i] += (arr[minIndex] % maxElement) * maxElement;
                minIndex++;
            }
        }

        for (int i = 0; i < n; i++) {
            arr[i] = arr[i]/maxElement;
        }
    }
}
