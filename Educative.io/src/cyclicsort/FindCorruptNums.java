package cyclicsort;

public class FindCorruptNums {

    public static int[] findNumbers(int[] nums) {

        int i = 0;
        while (i < nums.length) {
            int j = nums[i] - 1;
            if (nums[i] != nums[j])
                Utility.swap(nums, i, j);
            else
                i++;
        }

        for (i = 0; i < nums.length; i++) {
            if (i +1 != nums[i]) {
                return new int[] { nums[i], i + 1};
            }
        }

        return new int[] { -1, -1 };
    }

    public static void main(String[] args) {
        int[] nums = FindCorruptNums.findNumbers(new int[] { 3, 1, 2, 5, 2 });
        System.out.println(nums[0] + ", " + nums[1]);
        nums = FindCorruptNums.findNumbers(new int[] { 3, 1, 2, 3, 6, 4 });
        System.out.println(nums[0] + ", " + nums[1]);
    }
}
