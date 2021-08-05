package sorting.basic;

public class BinaryArraySorting {
    static int[] SortBinaryArray(int arr[], int n) {
        int zeroIndex = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                swap(arr, zeroIndex++, i);
            }
        }
        return arr;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
