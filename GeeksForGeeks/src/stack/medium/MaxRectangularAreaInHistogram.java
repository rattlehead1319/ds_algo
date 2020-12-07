package stack.medium;

import java.util.*;

public class MaxRectangularAreaInHistogram {
    public static long getMaxArea(long hist[], long n)  {
        long[] ps = getPreviousSmaller(hist, (int) n);
        long[] ns = getNextSmaller(hist, (int) n);
        long result = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            long area = hist[i];
            area += (i - ps[i] - 1) * hist[i];
            area += (ns[i] - i - 1) * hist[i];
            result = Math.max(result, area);
        }
        return result;
    }

    private static long[] getPreviousSmaller(long[] hist, int n) {
        Stack<Integer> stack = new Stack<>();
        long[] result = new long[n];
        result[0] = -1;
        stack.push(0);
        for (int i = 1; i < n; i++) {
            while (!stack.isEmpty() && hist[i] <= hist[stack.peek()]) {
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

    private static long[] getNextSmaller(long[] hist, int n) {
        Stack<Integer> stack = new Stack<>();
        long[] result = new long[n];
        result[n-1] = n;
        stack.push(n-1);
        for (int i = n-2; i >= 0; i--) {
            while (!stack.isEmpty() && hist[i] <= hist[stack.peek()]) {
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

    public static void main (String[] args) {
        long[] in = new long[]{6, 2, 5, 4, 5, 1, 6};
        System.out.println(MaxRectangularAreaInHistogram.getMaxArea(in, 7));
        in = new long[]{7, 2, 8, 9, 1, 3 ,6, 5};
        System.out.println(MaxRectangularAreaInHistogram.getMaxArea(in, 8));
    }
}
