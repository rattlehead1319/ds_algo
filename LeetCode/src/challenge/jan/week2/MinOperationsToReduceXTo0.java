package challenge.jan.week2;

//This is a tricky one. Twist of Maximum Subarray problem

public class MinOperationsToReduceXTo0 {
    public int minOperations(int[] nums, int x) {

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum < x) {
            return -1;
        }

        if (nums.length == 1) {
            if (nums[0] == x) {
                return 1;
            }
            return -1;
        }

        int l = 0;
        int r = 1;

        int remSum = sum - x;
        int maxSubArraySize = Integer.MIN_VALUE;
        int currSum = nums[0];
        while (l < nums.length && r < nums.length) {
            if (currSum == remSum) {
                maxSubArraySize = Math.max(maxSubArraySize, r-l);
                currSum += nums[r++];
            } else if (nums[r] + currSum < remSum) {
                currSum += nums[r++];
            } else if (nums[r] + currSum > remSum) {
                currSum -= nums[l++];
            } else {
                maxSubArraySize = Math.max(maxSubArraySize, r-l+1);
                currSum += nums[r++];
            }
        }
        return maxSubArraySize == Integer.MIN_VALUE ? -1 : (nums.length - maxSubArraySize);
    }
}
