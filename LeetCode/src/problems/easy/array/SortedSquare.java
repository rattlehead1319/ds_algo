package problems.easy.array;

public class SortedSquare {
    public int[] sortedSquares(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        int[] result = new int[nums.length];
        int resultIndex = nums.length - 1;

        while (left <= right) {
            int square = 0;
            if (Math.abs(nums[right]) > Math.abs(nums[left])) {
                square = nums[right--];
            } else {
                square = nums[left++];
            }

            result[resultIndex--] = square * square;
        }

        return result;
    }
}
