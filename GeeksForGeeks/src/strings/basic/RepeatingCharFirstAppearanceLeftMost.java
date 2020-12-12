package strings.basic;

import java.util.Arrays;

public class RepeatingCharFirstAppearanceLeftMost {
    static int repeatedCharacter(String S)
    {
        int[] distinctChars = new int[256];
        Arrays.fill(distinctChars, -1);
        int result = Integer.MAX_VALUE;

        for (int i = 0; i < S.length(); i++) {
            int fi = distinctChars[S.charAt(i)];
            if (fi == -1) {
                distinctChars[S.charAt(i)] = i;
            } else {
                result = Math.min(result, fi);
            }
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
