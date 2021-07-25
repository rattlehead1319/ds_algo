package problems.medium.stack;

import java.util.*;

public class BasicCalculator2 {
    public int calculate(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        Stack<Integer> stack = new Stack<>();
        int currentNumber = 0;
        int n = s.length();
        char operation = '+';

        for (int i = 0; i < n; i++) {
            char x = s.charAt(i);
            if (Character.isDigit(x)) {
                currentNumber = (currentNumber * 10) + Character.getNumericValue(x);
            }
            if (!Character.isDigit(x) && !Character.isWhitespace(x) || i == n - 1) {
                if (operation == '-') {
                    stack.push(-currentNumber);
                } else if (operation == '+') {
                    stack.push(currentNumber);
                } else if (operation == '*') {
                    int z = stack.pop() * currentNumber;
                    stack.push(z);
                } else if (operation == '/') {
                    int z = stack.pop() / currentNumber;
                    stack.push(z);
                }
                operation = x;
                currentNumber = 0;
            }
        }

        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }

        return result;
    }
}
