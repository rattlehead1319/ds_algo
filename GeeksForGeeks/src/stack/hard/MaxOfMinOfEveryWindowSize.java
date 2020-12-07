package stack.hard;

import java.util.*;

public class MaxOfMinOfEveryWindowSize {
    static int[] printMaxOfMin(int[] arr, int N) {
        int[] ps = previousSmall(arr, N);
        int[] ns = nextSmall(arr, N);
        int[] result = new int[N+1];
        for (int i = 0; i < N; i++) {
            int len = ns[i] - ps[i] - 1;
            result[len] = Math.max(result[len], arr[i]);
        }
        result = Arrays.copyOfRange(result, 1, N+1);
        for (int i = N-2; i >= 0 ; i--) {
            result[i] = Math.max(result[i], result[i+1]);
        }
        return result;
    }

    static int[] previousSmall(int[] arr, int n) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[n];
        result[0] = -1;
        stack.push(0);
        for (int i = 1; i < n; i++) {
            while (!stack.isEmpty() && arr[i] <= arr[stack.peek()]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = stack.peek();
            }
            stack.push(i);
        }
        return result;
    }

    static int[] nextSmall(int[] arr, int n) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[n];
        result[n-1] = n;
        stack.push(n-1);
        for (int i = n-2; i >= 0; i--) {
            while (!stack.isEmpty() && arr[i] <= arr[stack.peek()]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                result[i] = n;
            } else {
                result[i] = stack.peek();
            }
            stack.push(i);
        }
        return result;
    }
}
