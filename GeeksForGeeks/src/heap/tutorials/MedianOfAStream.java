package heap.tutorials;

import java.util.*;
//Time Complexity -> O(nlogn)
public class MedianOfAStream {
    private List<Double> findMedian(int[] arr) {

        List<Double> result = new ArrayList<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        maxHeap.add(arr[0]);
        for (int index = 1; index < arr.length; index++) {
            if (arr[index] > maxHeap.peek()) {
                if (maxHeap.size() != minHeap.size()) {
                    minHeap.add(arr[index]);
                } else {
                    maxHeap.add(arr[index]);
                }
            } else {
                if (maxHeap.size() != minHeap.size()) {
                    minHeap.add(maxHeap.poll());
                    maxHeap.add(arr[index]);
                } else {
                    maxHeap.add(arr[index]);
                }
            }

            if (index%2 != 0) {
                result.add(new Double(minHeap.peek()));
            } else {
                double first = new Double(minHeap.peek());
                double second = new Double(maxHeap.peek());
                double value = (first+second)/2;
                result.add(value);
            }
        }
        return result;
    }

}
