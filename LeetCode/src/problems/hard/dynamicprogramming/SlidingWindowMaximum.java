package problems.hard.dynamicprogramming;

import java.util.*;

public class SlidingWindowMaximum {
    class Helper {
        int index;
        int value;
        Helper (int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
    public int[] maxSlidingWindow(int[] nums, int k) {

        //return mySol(nums, k);
        return efficientSol(nums, k);
    }

    private int[] efficientSol(int[] nums, int k) {
        int n = nums.length;
        if (n * k == 0) return new int[0];
        if (k == 1) return nums;

        int [] left = new int[n];
        left[0] = nums[0];
        int [] right = new int[n];
        right[n - 1] = nums[n - 1];
        for (int i = 1; i < n; i++) {
            // from left to right
            if (i % k == 0) left[i] = nums[i];  // block_start
            else left[i] = Math.max(left[i - 1], nums[i]);

            // from right to left
            int j = n - i - 1;
            if ((j + 1) % k == 0) right[j] = nums[j];  // block_end
            else right[j] = Math.max(right[j + 1], nums[j]);
        }

        int [] output = new int[n - k + 1];
        for (int i = 0; i < n - k + 1; i++)
            output[i] = Math.max(left[i + k - 1], right[i]);

        return output;
    }

    //this is nlogn time complexity
    private int[] mySol(int[] nums, int k) {

        PriorityQueue<Helper> pq = new PriorityQueue<>(
                (a,b) -> b.value - a.value
        );

        int i = 0;
        for (; i < k; i++) {
            pq.add(new Helper(i, nums[i]));
        }

        int[] result = new int[nums.length - k + 1];
        int resultIndex = 0;
        result[resultIndex++] = pq.peek().value;
        Set<Integer> removed = new HashSet<>();
        int left = 0;

        while (i < nums.length) {
            removed.add(left++);
            pq.add(new Helper(i, nums[i]));
            while(!pq.isEmpty() && removed.contains(pq.peek().index)) {
                pq.poll();
            }
            result[resultIndex++] = pq.peek().value;
            i++;
        }

        return result;
    }
}
