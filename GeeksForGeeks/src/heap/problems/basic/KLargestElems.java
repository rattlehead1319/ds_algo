package heap.problems.basic;

import java.util.*;

public class KLargestElems {
    public static ArrayList<Integer> kLargest(int arr[], int n, int k)
    {
        ArrayList<Integer> result = new ArrayList<>();
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

        while (!minHeap.isEmpty()) {
            result.add(minHeap.poll());
        }
        Collections.sort(result, Collections.reverseOrder());
        return result;
    }
}
