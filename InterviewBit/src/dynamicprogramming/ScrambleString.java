package dynamicprogramming;

import java.util.*;

public class ScrambleString {
    Map<String, Integer> map = new HashMap<>();
    public int isScramble(final String A, final String B) {
        if (A.length() != B.length()) {
            return 0;
        }

        if (A.equals(B)) {
            return 1;
        }

        String key = A + "*" + B;
        if (map.containsKey(key)) {
            return map.get(key);
        }

        int len = A.length();
        for (int i = 1; i < len; i++) {
            if ( (isScramble(A.substring(0, i), B.substring(0, i)) == 1 && isScramble(A.substring(i), B.substring(i)) == 1) ||
                    (isScramble(A.substring(0, i), B.substring(len - i)) == 1 && isScramble(A.substring(i), B.substring(0, len - i)) == 1)
            ) {
                map.put(key, 1);
                return 1;
            }
        }

        map.put(key, 0);
        return 0;
    }
}
