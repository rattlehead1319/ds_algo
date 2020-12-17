package sorting.basic;

public class BubbleSort {
    void bubbleSort(int arr[], int n)
    {
        for (int i = 0; i < n-1; i++)
            bubble(arr, i, n);
    }

    static void bubble(int arr[], int i, int n)
    {
        for (int j = i+1; j < n; j++) {
            if (arr[i] > arr[j]) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
    }
}
