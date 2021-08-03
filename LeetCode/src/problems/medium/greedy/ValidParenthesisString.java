package problems.medium.greedy;

public class ValidParenthesisString {
    public boolean checkValidString(String s) {
        int lo = 0;
        int hi = 0;
        for (char x: s.toCharArray()) {
            lo += x == '(' ? 1 : -1;
            hi += x != ')' ? 1 : -1;
            if (hi < 0) {
                break;
            }
            lo = Math.max(lo, 0);
        }
        return lo == 0;
    }
}
