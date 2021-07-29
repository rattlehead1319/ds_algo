package problems.easy.array;

public class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {

        int[] nums = new int[1000];
        for (int num: nums1) {
            nums[num]++;
        }

        int size = 0;
        for (int num: nums2) {
            if (nums[num] > 0) {
                nums[num] = -1;
                size++;
            }
        }

        int[] result = new int[size];
        int resultIndex = 0;
        for (int i = 0; i < 1000; i++) {
            if (nums[i] == -1) {
                result[resultIndex++] = i;
            }
        }
        return result;
    }
}
