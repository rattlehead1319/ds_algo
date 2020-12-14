package hashing.easy;

import java.util.*;

public class HashingForPair1 {
    public static int sumExists(int arr[], int N, int sum)
    {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            if (set.contains(sum - arr[i])) {
                return 1;
            }
            set.add(arr[i]);
        }
        return 0;
    }
}
