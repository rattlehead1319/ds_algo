package problems.easy.strings;

import java.util.*;

public class MakeTheStingGreat {
    public String makeGood(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            int curr = s.charAt(i);
            if (!stack.isEmpty()) {
                int prev = stack.peek();
                if (Math.abs(prev - curr) == 32) {
                    stack.pop();
                    continue;
                }
            }
            stack.push(s.charAt(i));
        }

        StringBuilder sb = new StringBuilder("");
        for (Character c : stack) {
            sb.append(c);
        }

        return sb.toString();
    }
}
