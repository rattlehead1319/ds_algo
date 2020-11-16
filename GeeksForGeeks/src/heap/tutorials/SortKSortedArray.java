package heap.tutorials;

import java.util.*;

public class SortKSortedArray {
    private void sort (int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i <= k; i++) { //O(klogk)
            pq.add(arr[i]);
        }
        int index = 0;
        for (int i = k+1; i < arr.length; i++) { //O(n-k-1(logk + logk)) removal and insertion both will be logk
            arr[index++] = pq.poll();
            pq.add(arr[i]);
        }

        while (!pq.isEmpty()) {
            arr[index++] = pq.poll(); //O(klogk)
        }

        //Overall time complexity => O(klogk + n-k(logk) + klogk) => O(n+k(logk))
    }
}
