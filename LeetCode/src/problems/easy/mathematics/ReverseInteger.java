package problems.easy.mathematics;

import java.util.*;

public class ReverseInteger {
    public int reverse(int x) {

        if (x == 0) {
            return 0;
        }

        boolean isNegative = false;
        if (x < 0) {
            isNegative = true;
        }

        x = Math.abs(x);
        Stack<Integer> st = new Stack();

        while (x > 0) {
            st.push(x % 10);
            x = x/10;
        }

        int i = 0;
        long result = 0;
        while (!st.isEmpty()) {
            result += (long)st.pop() * (long)Math.pow(10, i);
            i++;
        }

        if (result > Integer.MAX_VALUE) {
            return 0;
        }

        if (isNegative) {
            result = 0 - result;
        }

        return (int)result;
    }
}
