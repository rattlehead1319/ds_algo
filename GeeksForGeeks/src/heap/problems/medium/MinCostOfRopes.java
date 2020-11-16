package heap.problems.medium;

import java.util.*;

public class MinCostOfRopes {
    long minCost(long arr[], int n) {
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        for (int index = 0; index < n; index++) {
            minHeap.add(arr[index]);
        }
        long cost = 0;
        while (minHeap.size() != 1) {
            long firstMin = minHeap.poll();
            long secondMin = minHeap.poll();
            long sum = firstMin + secondMin;
            minHeap.add(sum);
            cost += sum;
        }
        return cost;
    }
}
