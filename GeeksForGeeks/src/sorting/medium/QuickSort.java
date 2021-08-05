package sorting.medium;

public class QuickSort {
    static void quickSort(int arr[], int low, int high) {
        if (low < high) {
            int partition = partition(arr, low, high);
            quickSort(arr, low, partition - 1);
            quickSort(arr, partition + 1, high);
        }
    }
    static int partition(int arr[], int low, int high) {
        int pivotLoc = low;
        int pivot = arr[high];
        for (int i = low; i <= high; i++) {
            if (arr[i] < pivot) {
                swap(arr, pivotLoc++, i);
            }
        }
        swap(arr, pivotLoc, high);
        return pivotLoc;
    }

    static void swap (int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
