package searching.basic;

public class SearchAnElementInASortedArray {
    static int searchInSorted(int arr[], int N, int K)
    {
        return bs(arr, 0, N-1, K);
    }

    static int bs (int[] arr, int low, int high, int x) {
        while (low <= high) {
            int mid = (low+high)/2;
            if (arr[mid] == x) {
                return 1;
            } else if (arr[mid] > x) {
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return -1;
    }
}
