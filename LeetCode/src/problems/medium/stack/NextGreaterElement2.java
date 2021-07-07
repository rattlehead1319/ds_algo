package problems.medium.stack;

import java.util.*;

public class NextGreaterElement2 {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();

        for (int i = nums.length - 1; i >= 0; i--) {
            stack.push(nums[i]);
        }

        int[] result = new int[nums.length];
        int resultIndex = nums.length - 1;

        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                result[resultIndex--] = -1;
            } else {
                result[resultIndex--] = stack.peek();
            }
            stack.push(nums[i]);
        }

        return result;
    }
}
