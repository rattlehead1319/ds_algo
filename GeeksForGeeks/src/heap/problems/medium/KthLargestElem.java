package heap.problems.medium;

import java.util.*;

public class KthLargestElem {

    public static int KthLargest(int arr[], int n, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        int index = 0;
        for (index = 0; index < k; index++) {
            minHeap.add(arr[index]);
        }

        while (index < n) {
            int val = arr[index++];
            if (val > minHeap.peek()) {
                minHeap.poll();
                minHeap.add(val);
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            result.add(minHeap.poll());
        }
        Collections.sort(result, Collections.reverseOrder());

        return result.get(k-1);
    }
}
