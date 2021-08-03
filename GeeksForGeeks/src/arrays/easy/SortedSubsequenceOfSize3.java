package arrays.easy;

import java.util.*;

public class SortedSubsequenceOfSize3 {
    ArrayList<Integer> find3Numbers(ArrayList<Integer> arr, int n) {

        int[] smaller = new int[n];
        int min = 0;
        smaller[min] = -1;

        for (int i = 1; i < n; i++) {
            if (arr.get(i) <= arr.get(min)) {
                min = i;
                smaller[i] = -1;
            } else {
                smaller[i] = min;
            }
        }

        int[] greater = new int[n];
        int max = n - 1;
        greater[max] = -1;
        for (int i = n - 2; i >= 0; i--) {
            if (arr.get(i) >= arr.get(max)) {
                max = i;
                greater[i] = -1;
            } else {
                greater[i] = max;
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (smaller[i] != -1 && greater[i] != -1) {
                result.add(arr.get(smaller[i]));
                result.add(arr.get(i));
                result.add(arr.get(greater[i]));
                return result;
            }
        }

        return result;
    }
}
