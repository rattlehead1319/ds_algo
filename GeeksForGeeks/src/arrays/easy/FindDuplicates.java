package arrays.easy;

import java.util.*;

public class FindDuplicates {
    public static ArrayList<Integer> duplicates(int arr[], int n) {

        for (int i = 0; i < n; i++) {
            arr[arr[i] % n] = arr[arr[i] % n] + n;
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr[i] /= n;
            if (arr[i] >= 2) {
                result.add(i);
            }
        }
        if (result.isEmpty()) {
            result.add(-1);
        }
        return result;
    }
}
