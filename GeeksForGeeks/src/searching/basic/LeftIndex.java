package searching.basic;

public class LeftIndex {
    static int leftIndex(int N, int arr[], int X)
    {
        return bs(arr, 0, N-1, X);
    }

    static int bs (int[] arr, int low, int high, int x) {
        while (low <= high) {
            int mid = (low + high)/2;
            if (arr[mid] > x) {
                high = mid-1;
            } else if (arr[mid] < x) {
                low = mid+1;
            } else {
                if (mid == 0 || arr[mid] != arr[mid-1]) {
                    return mid;
                } else {
                    high = mid-1;
                }
            }
        }
        return -1;
    }
}
