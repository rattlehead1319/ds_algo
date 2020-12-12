package strings.easy;

import java.util.Arrays;

public class NonRepeatingChar {
    static char nonrepeatingCharacter(String S)
    {
        int[] dc = new int[256];
        Arrays.fill(dc, -1);

        for (int i = 0; i < S.length(); i++) {
            if (dc[S.charAt(i)] == -1) {
                dc[S.charAt(i)] = i;
            } else {
                dc[S.charAt(i)] = -2;
            }
        }

        int index = Integer.MAX_VALUE;
        for (int i = 0; i < dc.length; i++) {
            if (dc[i] >= 0) {
                index = Math.min(index, dc[i]);
            }
        }

        return index == Integer.MAX_VALUE ? '$' : S.charAt(index);
    }
}
