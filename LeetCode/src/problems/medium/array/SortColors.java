package problems.medium.array;

public class SortColors {
    public void sortColors(int[] nums) {
        int curr = 0;
        int zeroIndex = 0;
        int twoIndex = nums.length - 1;

        while (curr <= twoIndex) {
            if (nums[curr] == 0) {
                swap(nums, zeroIndex, curr);
                zeroIndex++;
                curr++;
            } else if (nums[curr] == 2) {
                swap(nums, twoIndex, curr);
                twoIndex--;
            } else {
                curr++;
            }
        }
    }

    private void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}
