package hashing.medium;

import java.util.*;

public class ZeroSumSubarrays {
    public static int findSubarray(int[] arr ,int n)
    {
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;
        int preSum = 0;

        for (int i = 0; i < n; i++) {
            preSum += arr[i];
            if (preSum == 0) {
                result++;
            }
            Integer x = map.get(preSum);
            if (x == null) {
                map.put(preSum, 1);
            } else {
                result += x;
                map.put(preSum, x+1);
            }
        }
        return result;
    }
}
