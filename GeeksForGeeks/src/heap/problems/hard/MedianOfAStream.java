package heap.problems.hard;

import java.util.*;

public class MedianOfAStream {
    static PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
    static PriorityQueue<Integer> min = new PriorityQueue<>();

    // Function to insert heap
    public static void insertHeap(int x)
    {
        if (max.isEmpty()) {
            max.add(x);
            return;
        }
        if (max.size() <= min.size()) {
            if (x > min.peek()) {
                max.add(min.poll());
                min.add(x);
            } else {
                max.add(x);
            }
        } else {
            if (x < max.peek()) {
                max.add(x);
                min.add(max.poll());
            } else {
                min.add(x);
            }
        }

    }

    // function to getMedian
    public static double getMedian()
    {
        if (max.size() == min.size()) {
            return new Double((max.peek() + min.peek())/2);
        }
        return new Double(max.peek());
    }
}
