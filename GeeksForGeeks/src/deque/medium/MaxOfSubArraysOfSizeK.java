package deque.medium;

import java.util.*;

public class MaxOfSubArraysOfSizeK {
    static ArrayList <Integer> max_of_subarrays(int arr[], int n, int k)
    {
        ArrayList<Integer> result = new ArrayList<>();
        Deque<Integer> dq = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            while(!dq.isEmpty() && arr[i] >= arr[dq.peekLast()]) {
                dq.pollLast();
            }
            dq.addLast(i);
        }
        for (int i = k; i < n; i++) {
            result.add(arr[dq.peek()]);
            while (!dq.isEmpty() && dq.peek() <= i - k) {
                dq.pollFirst();
            }
            while (!dq.isEmpty() && arr[i] >= arr[dq.peekLast()]) {
                dq.pollLast();
            }
            dq.addLast(i);
        }
        result.add(arr[dq.peek()]);
        return result;
    }
}
