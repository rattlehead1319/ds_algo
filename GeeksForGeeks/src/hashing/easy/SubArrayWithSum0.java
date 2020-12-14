package hashing.easy;

import java.util.*;

public class SubArrayWithSum0 {
    static boolean findsum(int arr[],int n)
    {
        Set<Integer> preSum = new HashSet<>();

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (preSum.contains(sum) || sum == 0) {
                return true;
            }
            preSum.add(sum);
        }
        return false;
    }
}
