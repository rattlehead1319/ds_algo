package searching.easy;

public class MinimumNumber {
    static long minNumber(int arr[], long low, long high)
    {
        long n = Long.valueOf(arr.length);

        while (low <= high) {
            long mid = (low+high)/2;

            if (mid < n-1 && arr[(int)mid] > arr[(int)(mid+1)]) {
                return Long.valueOf(arr[(int)(mid+1)]);
            }

            if (arr[(int)mid] < arr[(int)low]) {
                high = mid-1;
            } else {
                low = mid + 1;
            }
        }

        return Long.valueOf(arr[0]);
    }
}
