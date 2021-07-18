package problems.medium.dp;

import java.util.*;

public class LIS {
    public int lengthOfLIS(int[] nums) {
        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > list.get(list.size()-1)) {
                list.add(nums[i]);
            } else {
                int ceilIdx = getCeilIdx(list, nums[i], 0, list.size() - 1);
                list.set(ceilIdx, nums[i]);
            }
        }
        return list.size();
    }

    private int getCeilIdx(List<Integer> list, int target, int left, int right) {
        int result = right;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) >= target) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }
}
