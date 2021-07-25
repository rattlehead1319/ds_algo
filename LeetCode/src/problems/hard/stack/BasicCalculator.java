package problems.hard.stack;

import java.util.*;

public class BasicCalculator {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int sign = 1;
        int result = 0;
        int currentNumber = 0;

        for (int i = 0; i < s.length(); i++) {
            char x = s.charAt(i);
            if (Character.isDigit(x)) {
                currentNumber = currentNumber * 10 + Character.getNumericValue(x);
            }
            if (x == '+') {
                result += sign * currentNumber;
                sign = 1;
                currentNumber = 0;
            } else if (x == '-') {
                result += sign * currentNumber;
                sign = -1;
                currentNumber = 0;
            } else if (x == '(') {
                stack.push(result);
                stack.push(sign);

                sign = 1;
                result = 0;
            } else if (x == ')') {

                result += sign * currentNumber;

                //sign earlier pushed into stack
                result *= stack.pop();

                //previous evaluated stuff pushed into stack
                result += stack.pop();

                currentNumber = 0;
            }
        }

        return result + (sign * currentNumber);
    }
}
