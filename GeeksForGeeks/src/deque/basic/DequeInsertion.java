package deque.basic;

import java.util.*;

public class DequeInsertion {
    public static ArrayDeque<Integer> deque_Init(int arr[], int n)
    {
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            dq.addLast(arr[i]);
        }
        return dq;
    }
}
