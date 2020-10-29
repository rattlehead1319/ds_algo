import java.util.*;

class SlidingWindowMedian {

    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    public SlidingWindowMedian() {
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
        minHeap = new PriorityQueue<>((a, b) -> a - b);
    }

    public double[] findSlidingWindowMedian(int[] nums, int k) {
        double[] result = new double[nums.length - k + 1];

        int i = 0;
        for (i = 0; i < k; i++) {
            insert(nums[i]);
        }

        int index = 0;
        while (index < nums.length - k + 1) {
            result[index] = findMedian();
            boolean maxHas = maxHeap.remove(nums[index]);
            if (!maxHas) {
                minHeap.remove(nums[index]);
            }
            if (i < nums.length) {
                insert(nums[i++]);
            }
            index++;
        }
        return result;
    }

    private void insert(int num) {
        if (maxHeap.isEmpty() || maxHeap.peek() >= num) {
            maxHeap.add(num);
        } else {
            minHeap.add(num);
        }

        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.add(maxHeap.poll());
        } else if (maxHeap.size() < minHeap.size()) {
            maxHeap.add(minHeap.poll());
        }
    }

    private double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) /2.0;
        }
        return maxHeap.peek();
    }

    public static void main(String[] args) {
        SlidingWindowMedian slidingWindowMedian = new SlidingWindowMedian();
        double[] result = slidingWindowMedian.findSlidingWindowMedian(new int[] { 1, 2, -1, 3, 5 }, 2);
        System.out.print("Sliding window medians are: ");
        for (double num : result)
            System.out.print(num + " ");
        System.out.println();

        slidingWindowMedian = new SlidingWindowMedian();
        result = slidingWindowMedian.findSlidingWindowMedian(new int[] { 1, 2, -1, 3, 5 }, 3);
        System.out.print("Sliding window medians are: ");
        for (double num : result)
            System.out.print(num + " ");
    }

}