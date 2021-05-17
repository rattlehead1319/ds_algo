package searching.medium;

import java.util.*;

public class CountMoreThanNByKOccurences {
    public int countOccurence(int[] arr, int n, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        int count = 0;
        for (int value: map.values()) {
            if (value > n/k) {
                count++;
            }
        }
        return count;
    }
}
