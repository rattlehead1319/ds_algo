package problems.easy.array;

public class CheckIfSortedAndRotated {
    public boolean check(int[] nums) {
        int dipped = 0;
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[i-1]) {
                dipped++;
            }
        }
        if (nums[n-1] > nums[0]) {
            dipped++;
        }
        return dipped <= 1;
    }
}
