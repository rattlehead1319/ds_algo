package problems.medium.array;

public class FindMinInSortedArray {
    public int findMin(int[] nums) {
        int n = nums.length;

        if (n == 1) {
            return nums[0];
        }

        int left = 0;
        int right = n-1;

        if (nums[left] < nums[right]) {
            return nums[left];
        }

        while (left <= right) {
            int mid = left + (right - left)/2;

            if (nums[mid] > nums[mid+1]) {
                return nums[mid+1];
            }
            if (nums[mid] < nums[mid-1]) {
                return nums[mid];
            }

            if (nums[mid] > nums[0]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
