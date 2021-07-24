package problems.easy.array;

public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            while (left < nums.length && nums[left] != 0) {
                left++;
            }
            while (right < nums.length && nums[right] == 0) {
                right++;
            }
            if (left < right && right < nums.length) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
            right++;
        }
    }
}
