package sorting.basic;

public class BinaryArraySorting {
    static void binSort(int arr[], int n)
    {
        if (n == 0 || n == 1) {
            return;
        }

        int i = 0;
        int j = n-1;

        while (i <= j && j >= 0) {
            while (i <= j && arr[i] == 0) {
                i++;
            }

            while (j >= 0 && arr[j] == 1) {
                j--;
            }

            if (i <= j) {
                swap(arr, i, j);
            }
        }
    }

    static void swap (int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
