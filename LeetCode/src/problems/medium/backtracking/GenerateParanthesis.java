package problems.medium.backtracking;

import java.util.*;

public class GenerateParanthesis {
    public List<String> generateParenthesis(int n) {
        //return notSoEfficientMethod(n);
        List<String> result = new ArrayList<>();
        backtrack(result, new StringBuilder(), 0, 0, n);
        return result;
    }

    private List<String> notSoEfficientMethod (int n) {
        String current = "()";
        n--;
        Set<String> set = new HashSet<>();
        generateParenthesisRec(set, current, n);
        return new ArrayList(set);
    }

    private void generateParenthesisRec(Set<String> set, String current, int n) {
        if (n == 0) {
            set.add(current);
            return;
        }
        String x = new String(current);
        for (int i = 1; i <= x.length() ; i++) {
            String left = x.substring(0, i);
            String right = "";
            if (i < x.length()) {
                right = x.substring(i, x.length());
            }
            current = left + "()" + right;
            if (!set.contains(current)) {
                generateParenthesisRec(set, current, n-1);
            }
        }
    }

    private void backtrack(List<String> result, StringBuilder curr, int open, int close, int max) {
        if (curr.length() == max*2) {
            result.add(curr.toString());
            return;
        }

        if (open < max) {
            curr.append("(");
            backtrack(result, curr, open + 1, close, max);
            curr.deleteCharAt(curr.length() - 1);
        }

        if (close < open) {
            curr.append(")");
            backtrack(result, curr, open, close + 1, max);
            curr.deleteCharAt(curr.length() - 1);
        }
    }
}
