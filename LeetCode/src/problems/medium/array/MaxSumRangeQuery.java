package problems.medium.array;

import java.util.*;

public class MaxSumRangeQuery {
    public int maxSumRangeQuery(int[] nums, int[][] requests) {

        int n = nums.length;
        int[] counts = new int[n];
        for (int[] request: requests) {
            int start = request[0];
            int end = request[1] + 1;
            counts[start]++;
            if (end < n) {
                counts[end]--;
            }
        }

        for (int i = 1; i < n; i++) {
            counts[i] += counts[i-1];
        }

        Arrays.sort(nums);
        Arrays.sort(counts);

        long result = 0;
        for (int i = 0; i < n; i++) {
            result += (long)nums[i] * (long)counts[i];
        }

        return (int)(result % 1000000007);
    }
}
