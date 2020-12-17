package sorting.easy;

public class InsertionSort {
    static void insertionSort(int arr[], int n)
    {
        for (int i = 1; i < n; i++)
            insert(arr, i);
    }

    static void insert(int arr[],int i)
    {
        int j = i-1;
        int temp = arr[i];
        while (j >= 0 && arr[j] > temp) {
            arr[j+1] = arr[j];
            j--;
        }
        arr[j+1] = temp;
    }
}
