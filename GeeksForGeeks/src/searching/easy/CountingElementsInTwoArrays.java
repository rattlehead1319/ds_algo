package searching.easy;

import java.util.*;

public class CountingElementsInTwoArrays {
    public static ArrayList<Integer> countEleLessThanOrEqual(int arr1[], int arr2[], int m, int n)
    {
        Arrays.sort(arr2);
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            result.add(getShorterElements(arr2, 0, arr1[i]));
        }
        return result;
    }

    private static int getShorterElements(int[] arr, int low, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left)/2;
            if (arr[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return Math.max(left, right) - low;
    }
}
