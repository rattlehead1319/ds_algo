package hashing.easy;

import java.util.*;

public class CountNonRepeatedElements {
    static long countNonRepeated(int arr[], int n)
    {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        long count = 0;
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if (entry.getValue() == 1) {
                count++;
            }
        }

        return count;
    }
}
