package sorting.easy;

import java.util.*;

public class IntersectionOfTwoSortedArrays {
    static ArrayList<Integer> printIntersection(int arr1[], int arr2[], int n, int m)
    {
        ArrayList<Integer> result = new ArrayList<>();
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (i > 0 && arr1[i-1] == arr1[i]) {
                i++;
                continue;
            }
            if (arr1[i] < arr2[j]) {
                i++;
            } else if (arr1[i] > arr2[j]) {
                j++;
            } else {
                result.add(arr1[i]);
                i++;
                j++;
            }
        }

        if (result.size() == 0) {
            result.add(-1);
        }

        return result;
    }
}
