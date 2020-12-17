package sorting.easy;

import java.util.*;

public class UnionOfTwoSortedArrays {
    public static ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m)
    {
        ArrayList<Integer> result = new ArrayList<>();

        int prev = -1;
        int i = 0;
        int j = 0;

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j] && arr1[i] != prev) {
                result.add(arr1[i]);
                prev = arr1[i];
                i++;
            } else if (arr2[j] < arr1[i] && arr2[j] != prev) {
                result.add(arr2[j]);
                prev = arr2[j];
                j++;
            } else if (arr1[i] < arr2[j]) {
                i++;
            } else if (arr2[j] < arr1[i]) {
                j++;
            } else if (arr1[i] != prev) {
                result.add(arr1[i]);
                prev = arr1[i];
                i++;
                j++;
            } else {
                i++;
                j++;
            }
        }

        while (i < arr1.length) {
            if (arr1[i] != prev) {
                result.add(arr1[i]);
                prev = arr1[i];
            }
            i++;
        }

        while (j < arr2.length) {
            if (arr2[j] != prev) {
                result.add(arr2[j]);
                prev = arr2[j];
            }
            j++;
        }

        return result;
    }
}
