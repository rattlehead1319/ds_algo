package searching.easy;

public class SearchInSortedAndRotatedArray {
    static int Search(int array[], int target)
    {
        int n = array.length;
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = left + (right - left)/2;
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] >= array[left]) {
                if (target <= array[mid] && target >= array[left]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target >= array[mid] && target <= array[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }
}
