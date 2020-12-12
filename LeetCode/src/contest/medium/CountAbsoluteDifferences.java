package contest.medium;

public class CountAbsoluteDifferences {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int[] result = new int[nums.length];
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
        }
        int x = 0;
        for (int i = 0; i < nums.length; i++) {
            int y = total-x;
            int z = y - nums[i]*(nums.length-i);
            z = z + Math.abs(x-i*nums[i]);
            result[i] = z;
            x += nums[i];
        }
        return result;
    }
}
