package heap.problems.medium;

import java.util.*;

public class KthSmallestElem {
    public static int kthSmallest(int arr[], int n, int k) {
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Collections.reverseOrder());
        int index = 0;
        for (index = 0; index < k; index++) {
            maxQueue.add(arr[index]);
        }

        while (index < n) {
            int val = arr[index++];
            if (val < maxQueue.peek()) {
                maxQueue.poll();
                maxQueue.add(val);
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!maxQueue.isEmpty()) {
            result.add(maxQueue.poll());
        }

        Collections.sort(result);
        return result.get(k - 1);
    }
}
