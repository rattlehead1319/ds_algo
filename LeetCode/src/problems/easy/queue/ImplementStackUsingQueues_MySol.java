package problems.easy.queue;

import java.util.*;

public class ImplementStackUsingQueues_MySol {
    Queue<Integer> queue;

    /** Initialize your data structure here. */
    public ImplementStackUsingQueues_MySol() {
        queue = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue.add(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        List<Integer> result = new ArrayList<>();
        popRec(result);
        reverse();
        return result.get(0);
    }

    private int popRec(List<Integer> result) {
        if (queue.isEmpty()) {
            return -1;
        }
        int x = queue.poll();

        int y = popRec(result);
        if (y == -1) {
            result.add(x);
        } else {
            queue.add(x);
        }
        return x;
    }

    private void reverse() {
        if (queue.isEmpty()) {
            return;
        }
        int x = queue.poll();
        reverse();
        queue.add(x);
    }

    /** Get the top element. */
    public int top() {
        List<Integer> result = new ArrayList<>();
        topRec(result);
        reverse();
        return result.get(0);
    }

    private int topRec(List<Integer> result) {
        if (queue.isEmpty()) {
            return -1;
        }
        int x = queue.poll();
        int y = topRec(result);
        if (y == -1) {
            result.add(x);
        }
        queue.add(x);
        return x;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}
