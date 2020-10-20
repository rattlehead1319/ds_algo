class MissingNumber {

    public static int findMissingNumber(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int j = nums[i];
            if (nums[i] < nums.length && nums[i] != nums[j])
                Utility.swap(nums, i, j);
            else
                i++;
        }


        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j) {
                return j;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(MissingNumber.findMissingNumber(new int[] { 4, 0, 3, 1 }));
        System.out.println(MissingNumber.findMissingNumber(new int[] { 8, 3, 5, 2, 4, 6, 0, 1 }));
    }
}
