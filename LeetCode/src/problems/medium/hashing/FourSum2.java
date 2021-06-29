package problems.medium.hashing;

import java.util.*;

public class FourSum2 {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        return kSumCount(new int[][]{nums1, nums2, nums3, nums4});
    }

    private int kSumCount(int[][] lists) {
        Map<Integer, Integer> map = new HashMap<>();
        addToHash(lists, map, 0, 0);
        return countComplements(lists, map, lists.length/2, 0);
    }

    private void addToHash(int[][] lists, Map<Integer, Integer> map, int index, int sum) {
        if (index == lists.length/2) {
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        if (index > lists.length/2) {
            return;
        }
        for (int x : lists[index]) {
            addToHash(lists, map, index + 1, sum + x);
        }
    }

    private int countComplements(int[][] lists, Map<Integer, Integer> map, int index, int complement)     {
        if (index == lists.length) {
            return map.getOrDefault(complement, 0);
        }
        int count = 0;
        for (int x : lists[index]) {
            count += countComplements(lists, map, index + 1, complement - x);
        }
        return count;
    }
}
