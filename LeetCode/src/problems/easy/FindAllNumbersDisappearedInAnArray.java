package problems.easy;

import java.util.*;

public class FindAllNumbersDisappearedInAnArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {

        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        int n = nums.length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);
        }
        max++;

        for (int i = 0; i < n; i++) {
            nums[(nums[i] - 1) % max] = nums[(nums[i] - 1) % max] + max;
        }

        for (int i = 0; i < n; i++) {
            nums[i] = nums[i]/max;
            if (nums[i] == 0) {
                result.add(i+1);
            }
        }

        return result;
    }
}
