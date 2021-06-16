package problems.medium.array;

import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int l = i + 1;
            int sum = 0 - nums[i];
            int r = nums.length - 1;

            while (l < r) {
                if (nums[l] + nums[r] == sum) {
                    result.add(Arrays.asList(nums[i], nums[l++], nums[r--]));
                    while (l < r && nums[l] == nums[l-1]) {
                        l++;
                    }
                } else if (nums[l] + nums[r] > sum) {
                    r--;
                } else {
                    l++;
                }
            }
        }
        return result;
    }
}
