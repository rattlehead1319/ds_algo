package problems.easy.array;

import java.util.*;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numberMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int x = target - nums[i];
            if (numberMap.containsKey(x)) {
                return new int[]{numberMap.get(x), i};
            }
            numberMap.put(nums[i], i);
        }
        return null;
    }
}
