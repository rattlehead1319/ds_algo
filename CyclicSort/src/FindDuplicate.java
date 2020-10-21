public class FindDuplicate {
    public static int findNumber(int[] nums) {

        int i = 0;
        while (i < nums.length) {
            int j = nums[i] - 1;
            if (nums[i] != nums[j])
                Utility.swap(nums, i, j);
            else
                i++;
        }

        for (i = 0; i < nums.length; i++) {
            if (i+1 != nums[i]) {
                return nums[i];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(FindDuplicate.findNumber(new int[] { 1, 4, 4, 3, 2 }));
        System.out.println(FindDuplicate.findNumber(new int[] { 2, 1, 3, 3, 5, 4 }));
        System.out.println(FindDuplicate.findNumber(new int[] { 2, 4, 1, 4, 4 }));
    }
}
