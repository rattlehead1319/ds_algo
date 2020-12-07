package stack.medium;

import java.util.*;

public class NextLargerElement {
    public static long[] nextLargerElement(long[] arr, int n) {
        Stack<Long> stack = new Stack<>();
        long[] result = new long[n];
        stack.push(arr[n-1]);
        result[n-1] = -1;
        for (int i = n-2; i >= 0; i--) {
            if (arr[i] > stack.peek()) {
                while (!stack.isEmpty() && arr[i] > stack.peek()) {
                    stack.pop();
                }
            }
            if (stack.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = stack.peek();
            }
            stack.push(arr[i]);
        }
        return result;
    }
}
