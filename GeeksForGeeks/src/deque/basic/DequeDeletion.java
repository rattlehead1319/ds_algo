package deque.basic;

import java.util.*;

public class DequeDeletion {
    public static void eraseAt(ArrayDeque<Integer> deq , int X)
    {
        if (X == 0) {
            deq.poll();
            return;
        }
        if (X == deq.size()) {
            deq.pollLast();
            return;
        }
        boolean removeFromBeginning = true;
        if (X > deq.size()/2) {
            removeFromBeginning = false;
        }
        if (removeFromBeginning) {
            int k = X;
            while (k-- > 0) {
                deq.addLast(deq.poll());
            }
            deq.poll();
            while (X-- > 0) {
                deq.addFirst(deq.pollLast());
            }
        } else {
            int k = deq.size() - 1 - X;
            int count = 0;
            while (k-- > 0) {
                deq.addFirst(deq.pollLast());
                count++;
            }
            deq.pollLast();
            while (count-- > 0) {
                deq.addLast(deq.poll());
            }
        }
    }

    public static void eraseInRange(ArrayDeque<Integer> deq , int start, int end)
    {
        int index = 0;
        int count = 0;
        while (index < start) {
            deq.addLast(deq.poll());
            index++;
            count++;
        }
        while (index < end) {
            deq.poll();
            index++;
        }
        while (count-- > 0) {
            deq.addFirst(deq.pollLast());
        }
    }

    public static void eraseAll(ArrayDeque<Integer> deq )
    {
        while(!deq.isEmpty()) {
            deq.poll();
        }
    }
}
