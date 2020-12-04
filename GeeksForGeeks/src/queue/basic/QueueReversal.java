package queue.basic;

import java.util.*;

public class QueueReversal {
    public Queue<Integer> rev(Queue<Integer> q){
        Stack<Integer> stack = new Stack<>();
        while (!q.isEmpty()) {
            stack.push(q.poll());
        }
        while (!stack.isEmpty()) {
            q.offer(stack.pop());
        }
        return q;
    }
}
