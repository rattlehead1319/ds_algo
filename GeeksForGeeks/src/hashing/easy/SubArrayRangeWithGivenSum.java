package hashing.easy;

import java.util.*;

public class SubArrayRangeWithGivenSum {
    static int subArraySum(int arr[], int n, int sum)
    {
        Map<Integer, Integer> map = new HashMap<>();
        int preSum = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            preSum += arr[i];
            if (sum == preSum) {
                count++;
            }
            if (map.containsKey(preSum - sum)) {
                count = count + map.get(preSum - sum);
            }
            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        }
        return count;
    }
}
