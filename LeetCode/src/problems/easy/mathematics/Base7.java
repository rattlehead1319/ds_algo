package problems.easy.mathematics;

import java.util.*;

public class Base7 {
    public String convertToBase7(int num) {
        if (num == 0) {
            return String.valueOf(num);
        }

        Stack<Integer> stack = new Stack<>();
        boolean isNegative = num < 0;

        num = Math.abs(num);

        while (num > 0) {
            stack.push(num % 7);
            num = num/7;
        }

        StringBuilder result = isNegative ? new StringBuilder("-") : new StringBuilder("");
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.toString();
    }
}
