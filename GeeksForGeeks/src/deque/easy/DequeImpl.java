package deque.easy;

import java.util.*;

public class DequeImpl {
    public static void push_back_pb(ArrayDeque<Integer> dq, int x){

        dq.offerLast(x);


    }

    /* Function to pop element from back
     * dq : dqueue From which element is to be popped
     */
    public static void pop_back_ppb(ArrayDeque<Integer> dq){

        dq.pollLast();

    }

    /* Function to return element from front
     * dq : dqueue from which element is to be returned
     */
    public static int front_dq(ArrayDeque<Integer> dq){

        return dq.isEmpty() ? -1 : dq.peekFirst();

    }

    /* Function to push element to front
     * dq : dqueue in which element is to be pushed
     * x : element to be pushed
     */
    public static void push_front_pf(ArrayDeque<Integer> dq, int x){

        dq.offerFirst(x);

    }
}
