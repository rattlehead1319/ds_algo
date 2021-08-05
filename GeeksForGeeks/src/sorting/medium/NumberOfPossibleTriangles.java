package sorting.medium;

import java.util.*;

public class NumberOfPossibleTriangles {
    static int findNumberOfTriangles(int arr[], int n) {
        Arrays.sort(arr);
        int result = 0;
        for (int i = n - 1; i >= 0; i--) {
            int left = 0;
            int right = i - 1;
            while (left < right) {
                if (arr[i] + arr[left] >= arr[right]) {
                    result += right - left;
                    right--;
                } else {
                    left++;
                }
            }
        }

        return result;
    }
}
