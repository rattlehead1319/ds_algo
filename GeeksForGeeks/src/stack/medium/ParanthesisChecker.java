package stack.medium;

import java.util.*;

public class ParanthesisChecker {
    static boolean ispar(String x)
    {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < x.length(); i++) {
            String curr = Character.toString(x.charAt(i));
            if (curr.equals("(") || curr.equals("{") || curr.equals("[")) {
                stack.push(curr);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                String stItem = stack.pop();
                if (curr.equals(")") && !stItem.equals("(")) {
                    return false;
                }
                if (curr.equals("}") && !stItem.equals("{")) {
                    return false;
                }
                if (curr.equals("]") && !stItem.equals("[")) {
                    return false;
                }
            }
        }
        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }
}
