package heap.problems.medium;

import java.util.*;

public class NearlySorted {

    ArrayList <Integer> nearlySorted(int arr[], int num, int k){
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int index = 0;
        for (index = 0; index <= k && index < num; index++) {
            minHeap.add(arr[index]);
        }

        ArrayList<Integer> result = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            result.add(minHeap.poll());
            if (index < num) {
                minHeap.add(arr[index++]);
            }
        }
        return result;
    }
}
