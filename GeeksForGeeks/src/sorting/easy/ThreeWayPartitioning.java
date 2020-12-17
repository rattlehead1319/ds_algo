package sorting.easy;

public class ThreeWayPartitioning {
    public void threeWayPartition(int array[], int a, int b)
    {
        int pivot = array[0];
        int low = 0;
        int mid = 0;
        int high = array.length-1;

        while (mid <= high) {
            if (array[mid] < a) {
                swap(array, low, mid);
                low++;
                mid++;
            } else if (array[mid] >= a && array[mid] <= b) {
                mid++;
            } else if (array[mid] > b) {
                swap(array, mid, high);
                high--;
            }
        }
    }

    private void swap (int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
