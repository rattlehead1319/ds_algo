package problems.medium.array;

import java.util.*;

public class FirstAndLastPositionInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        Arrays.fill(result, -1);

        if (nums == null || nums.length == 0) {
            return result;
        }

        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start)/2;
            if (nums[mid] == target) {
                if ((mid - 1 >= 0 && nums[mid - 1] != target) || mid == 0) {
                    result[0] = mid;
                    break;
                } else {
                    end = mid - 1;
                }
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        start = 0;
        end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start)/2;
            if (nums[mid] == target) {
                if ((mid + 1 < nums.length && nums[mid + 1] != target) ||
                        mid == nums.length - 1)
                {
                    result[1] = mid;
                    break;
                } else {
                    start = mid + 1;
                }
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return result;
    }
}
