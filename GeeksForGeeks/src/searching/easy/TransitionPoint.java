package searching.easy;

public class TransitionPoint {
    int transitionPoint(int arr[], int n) {
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int mid = left + (right - left)/2;
            if ((mid == 0 && arr[mid] == 1) ||
                    (arr[mid] == 1 && arr[mid - 1] == 0)
            )
            {
                return mid;
            } else if (arr[mid] == 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }
}
