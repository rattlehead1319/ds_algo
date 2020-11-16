package heap.tutorials;

import java.util.*;

public class KLargestElems {
    private static int[] findKLargest (int[] arr, int k) {
        int[] result = new int[k];

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int index = 0;
        for (index = 0; index < k; index++) { //O(k)
            pq.add(arr[index]);
        }

        while (index < arr.length) {
            if (arr[index] > pq.peek()) { //O(n-k(logk))
                pq.poll();
                pq.add(arr[index]);
            }
        }

        index = 0;
        Iterator<Integer> it = pq.iterator();
        while (it.hasNext()) {
            result[index++] = it.next();
        }

        return result;
     }
}
