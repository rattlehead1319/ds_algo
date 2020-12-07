package stack.medium;

import java.util.*;

public class StockSpan {
    public static int[] calculateSpan(int price[], int n)
    {
        int[] result = new int[n];

        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        result[0] = 1;
        for (int i = 1; i < n; i++) {
            while (!stack.isEmpty() && price[i] >= price[stack.peek()]) {
                stack.pop();
            }
            result[i] = stack.isEmpty() ? i+1 : i - stack.peek();
            stack.push(i);
        }
        return result;
    }
}
