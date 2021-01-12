package arrays.medium;

public class CheckIfArraySortedAndRotated {
    public static boolean checkRotatedAndSorted(int arr[], int num){

        int decreasedCount = 0;
        int increasedCount = 0;
        for (int i = 1; i < num; i++) {
            if (arr[i] < arr[i-1]) {
                decreasedCount++;
            } else {
                increasedCount++;
            }
        }
        boolean isIncreasing = increasedCount > decreasedCount;

        boolean isRotated = false;
        int start = 0;
        int end = 0;
        for (int i = 1; i < num; i++) {
            if ((isIncreasing && arr[i] < arr[i-1]) || (!isIncreasing && arr[i] > arr[i-1])) {
                start = i;
                end = i-1;
                isRotated = true;
                break;
            }
        }
        if (!isRotated) {
            return false;
        }
        while (start < num-1) {
            if ((isIncreasing && arr[start] > arr[start+1]) || (!isIncreasing && arr[start] < arr[start+1])) {
                return false;
            }
            start++;
        }
        while (end > 0) {
            if ((isIncreasing && arr[end] < arr[end-1]) || (!isIncreasing && arr[end] > arr[end-1]))  {
                return false;
            }
            end--;
        }

        if ((isIncreasing && arr[num-1] > arr[0]) || (!isIncreasing && arr[num-1] < arr[0])) {
            return false;
        }

        return true;
    }
}
