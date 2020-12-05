package stack.easy;

import java.util.*;

public class StackUsingTwoQueues {
    Queue<Integer> q1 = new LinkedList<Integer>();
    Queue<Integer> q2 = new LinkedList<Integer>();

    /*The method pop which return the element poped out of the stack*/
    int pop()
    {
        if (q2.isEmpty()) {
            return -1;
        }
        int x = q2.poll();
        while (!q1.isEmpty()) {
            q2.offer(q1.poll());
        }
        while (!q2.isEmpty() && q2.size() != 1) {
            q1.offer(q2.poll());
        }
        return x;
    }

    /* The method push to push element into the stack */
    void push(int a)
    {
        if (q2.isEmpty()) {
            q2.offer(a);
        } else {
            q1.offer(q2.poll());
            q2.offer(a);
        }
    }
}
