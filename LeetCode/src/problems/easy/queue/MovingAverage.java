package problems.easy.queue;

import java.util.*;

public class MovingAverage {
    int size = 0;
    int sum = 0;
    Queue<Integer> queue;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.size = size;
        queue = new LinkedList<>();
    }

    public double next(int val) {

        if (queue.size() == size) {
            sum -= queue.poll();
        }
        sum += val;
        queue.add(val);

        return (double)sum/(double)queue.size();
    }
}
