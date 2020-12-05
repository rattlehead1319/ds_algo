package stack.easy;

import java.util.*;

public class RemovingConsecutivePairs2 {
    public static String removePair(String str){
        Stack<String> stack = new Stack<>();
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            String curr = Character.toString(str.charAt(i));
            if (stack.isEmpty()) {
                stack.push(curr);
                result += curr;
            } else if (!curr.equals(stack.peek())) {
                stack.push(curr);
                result += curr;
            } else {
                stack.pop();
                result = result.substring(0, result.length() - 1);
            }
        }
        return result;
    }
}
