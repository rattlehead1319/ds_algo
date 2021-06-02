package problems.medium.array;

public class NextPermutation {
    public void nextPermutation(int[] nums) {

        int j = nums.length-2;
        while (j >= 0 && nums[j] >= nums[j+1]) {
            j--;
        }
        if (j >= 0) {
            int i = nums.length - 1;
            while (nums[i] <= nums[j]) {
                i--;
            }
            swap(nums, j, i);
        }
        reverse(nums, j+1, nums.length - 1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int l, int r) {
        while (l < r) {
            swap(nums, l, r);
            l++;
            r--;
        }
    }
}
