package heap.problems.medium;

import java.util.*;

public class KthLargestElemInStream {
    public void kthLargest(int arr[], int n, int k){
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 0; i < k-1; i++) {
            System.out.print(-1 + " ");
        }

        int index = 0;
        for (index = 0; index < k; index++) {
            minHeap.add(arr[index]);
        }
        System.out.print(minHeap.peek() + " ");

        while (index < arr.length) {
            if (arr[index] > minHeap.peek()) {
                minHeap.poll();
                minHeap.add(arr[index]);
            }
            index++;
            System.out.print(minHeap.peek() + " ");
        }
    }
}
