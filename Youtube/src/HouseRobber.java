public class HouseRobber {

    public int robHouse (int[] nums) {
        int n = nums.length;
        int[] dp = new int[n+1];

        dp[1] = nums[0];
        dp[2] = Math.max(nums[0], nums[1]);

        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(nums[i] + dp[i-2], dp[i-1]);
        }

        return dp[n];
    }
}
