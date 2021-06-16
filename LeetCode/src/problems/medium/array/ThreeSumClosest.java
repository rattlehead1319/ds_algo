package problems.medium.array;

import java.util.*;

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int minDiff = Integer.MAX_VALUE;
        int result = -1;
        for (int i = 0; i < nums.length - 2; i++) {
            int a = nums[i];
            int l = i+1;
            int r = nums.length - 1;
            while (l < r) {
                int sum = a + nums[l] + nums[r];
                if (sum == target) {
                    return target;
                } else if (sum < target) {
                    if (Math.abs(sum-target) < minDiff) {
                        minDiff = Math.abs(sum-target);
                        result = sum;
                    }
                    l++;
                } else {
                    if (Math.abs(sum-target) < minDiff) {
                        minDiff = Math.abs(sum-target);
                        result = sum;
                    }
                    r--;
                }
            }
        }
        return result;
    }
}
