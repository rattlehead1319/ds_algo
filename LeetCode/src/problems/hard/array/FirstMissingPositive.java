package problems.hard.array;

public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        int oneCount = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                oneCount++;
                break;
            }
        }

        if (oneCount == 0) {
            return 1;
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0 || nums[i] > n) {
                nums[i] = 1;
            }
        }

        for (int i = 0; i < n; i++) {
            int x = Math.abs(nums[i]);
            nums[x - 1] = -Math.abs(nums[x - 1]);
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }

        return n + 1;
    }
}
