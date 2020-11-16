package heap.tutorials;

import java.util.*;

public class MaxItemsWithGivenSum {
    public static int findMax(int[] arr, int sum) {
        int result = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) { //O(n)
            pq.add(arr[i]);
        }
        while (!pq.isEmpty()) { //O(result * logn)
            if (pq.peek() > sum) {
                break;
            } else {
                sum -= pq.poll();
                result++;
            }
        }
        return result;
    }
}
