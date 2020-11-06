package cyclicsort;

public class FirstMissingPositive {

    public static int findNumber(int[] nums) {

        int i = 0;
        while (i < nums.length) {
            int j = nums[i] - 1;
            if (i >= 0 &&  j>= 0 && j < nums.length && nums[i] != nums[j])
                Utility.swap(nums, i, j);
            else
                i++;
        }

        for (i = 0; i < nums.length; i++) {
            if (i+1 != nums[i]) {
                return i+1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(FirstMissingPositive.findNumber(new int[] { -3, 1, 5, 4, 2 }));
        System.out.println(FirstMissingPositive.findNumber(new int[] { 3, -2, 0, 1, 2 }));
        System.out.println(FirstMissingPositive.findNumber(new int[] { 3, 2, 5, 1 }));
    }
}
