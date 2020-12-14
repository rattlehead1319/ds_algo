package hashing.easy;

import java.util.*;

public class PositiveNegativePair {
    public static ArrayList<Integer>findPairs(int arr[], int n)
    {
        Map<Integer, Boolean> map = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            Boolean hasPair = map.get(0 - arr[i]);
            if (hasPair == null) {
                map.put(arr[i], false);
            } else {
                map.put(0 - arr[i], true);
                if (arr[i] > 0) {
                    result.add(0 - arr[i]);
                    result.add(arr[i]);
                } else {
                    result.add(arr[i]);
                    result.add(0 - arr[i]);
                }
            }
        }

        return result;
    }
}
