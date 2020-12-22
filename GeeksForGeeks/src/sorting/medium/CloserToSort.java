package sorting.medium;

public class CloserToSort {
    static long closer(int arr[], int n, long x)
    {

        int y = (int)x;
        int result = bs(arr, 0, n-1, y);
        return Long.valueOf(result);
    }

    static int bs (int[] arr, int low, int high, int x) {

        if (high >= low) {
            int mid = (low+high)/2;

            if (arr[mid] == x) {
                return mid;
            }
            if (mid > low && arr[mid-1] == x) {
                return mid-1;
            }
            if (mid < high && arr[mid+1] == x) {
                return mid+1;
            }


            if (arr[mid] < x) {
                return bs(arr, mid+2, high, x);
            }
            return bs(arr, low, mid-2, x);
        }
        return -1;
    }
}
