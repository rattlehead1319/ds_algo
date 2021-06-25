package problems.medium.greedy;

public class JumpGame2 {
    public int jump(int[] nums) {

        int farthest = 0;
        int jumps = 0;
        int currentjumpEnd = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);

            if (i == currentjumpEnd) {
                currentjumpEnd = farthest;
                jumps++;
            }
        }

        return jumps;
    }
}
