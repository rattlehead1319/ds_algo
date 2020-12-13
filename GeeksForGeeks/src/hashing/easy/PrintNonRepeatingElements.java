package hashing.easy;

import java.util.*;

public class PrintNonRepeatingElements {
    static ArrayList<Integer> printNonRepeated(int arr[], int n)
    {
        Map<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        for (int i = 0; i < n; i++) {
            if (map.get(arr[i]) == 1) {
                result.add(arr[i]);
            }
        }
        return result;
    }
}
