package searching.easy;

public class FloorInASortedArray {
    static int findFloor(long arr[], int left, int right, long x)
    {
        int res = -1;
        while (left <= right) {
            int mid = (left+right)/2;
            if (arr[mid] == x) {
                return mid;
            } else if (arr[mid] > x) {
                right = mid-1;
            } else {
                res = mid;
                left = mid+1;
            }
        }
        return res;
    }
}
