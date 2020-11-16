package heap.problems.medium;

import java.util.*;

public class KMostOccuring {
    void kMostFrequent(int arr[], int n, int k){

        Map<Integer, Integer> map = new HashMap<>();
        for (int index = 0; index < n; index++) {
            map.put(arr[index], map.getOrDefault(arr[index], 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>(
                (a,b) -> Integer.compare(b.getValue(), a.getValue())
        );

        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            maxHeap.add(entry);
        }

        int result = 0;
        for (int index = 0; index < k; index++) {
            result += maxHeap.poll().getValue();
        }
        System.out.println(result);
    }
}
