package queue.basic;

import java.util.*;

public class GenerateBinaryNumbers {
    static ArrayList<String> generate(long N)
    {
        ArrayList<String> result = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            result.add(getBinary(i));
        }
        return result;
    }

    static String getBinary(int n) {
        Stack<Integer> s = new Stack<>();
        while (n != 1) {
            s.push(n%2);
            n = n/2;
        }
        s.push(n);

        String r = "";
        while (!s.isEmpty()) {
            r += String.valueOf(s.pop());
        }
        return r;
    }
}
