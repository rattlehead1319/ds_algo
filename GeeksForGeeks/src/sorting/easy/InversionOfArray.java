package sorting.easy;

public class InversionOfArray {

    static long ic = 0;

    static long inversionCount(long arr[], long N)
    {
        ic = 0;
        mergeSort(arr, 0, N-1);
        return ic;
    }

    static void mergeSort (long[] arr, long low, long high) {
        if (low == high) {
            return;
        }
        long mid = (low + high)/2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);
        merge(arr, (int)low, (int)mid, (int)high);
    }

    static void merge (long[] arr, int low, int mid, int high) {
        long[] temp = new long[high-low+1];
        int t = 0;
        int x = low;
        int y = mid+1;
        while (x <= mid && y <= high) {
            if (arr[x] <= arr[y]) {
                temp[t++] = arr[x++];
            } else {
                ic += mid-x+1 ;
                temp[t++] = arr[y++];
            }
        }
        while (x <= mid) {
            temp[t++] = arr[x++];
        }
        while (y <= high) {
            temp[t++] = arr[y++];
        }
        for (int i = 0; i < high-low+1; i++) {
            arr[low+i] = temp[i];
        }
    }

    public static void main (String[] args) {
        long[] arr = new long[]{10, 10, 10};
        long ic = inversionCount(arr, 3);
        System.out.println(ic);
    }
}
