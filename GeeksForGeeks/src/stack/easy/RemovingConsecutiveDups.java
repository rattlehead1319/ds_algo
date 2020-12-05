package stack.easy;

import java.util.*;

public class RemovingConsecutiveDups {
    public static String removeConsecutiveDuplicates(String str){
        Stack<String> stack = new Stack<>();
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            String curr = Character.toString(str.charAt(i));
            if (stack.isEmpty()) {
                stack.push(curr);
                result += curr;
            } else if (!curr.equals(stack.peek())) {
                result += curr;
                stack.push(curr);
            }
        }
        return result;
    }
}
