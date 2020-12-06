package stack.easy;

import java.util.*;

public class EvaluationOfPostfix {
    public static int evaluatePostFix(String exp){
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);
            if (Character.isDigit(c)) {
                int val = Integer.parseInt(Character.toString(c));
                stack.push(val);
            } else {
                int second = stack.pop();
                int first = stack.pop();
                stack.push(getValue(first, second, c));
            }
        }
        return stack.pop();
    }

    private static int getValue(int a, int b, char c) {
        switch(c) {
            case '+':
                return a+b;
            case '-':
                return a-b;
            case '*':
                return a*b;
            case '/':
                return a/b;
        }
        return -1;
    }
}
