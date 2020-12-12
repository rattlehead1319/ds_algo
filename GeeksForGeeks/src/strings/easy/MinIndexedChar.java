package strings.easy;

import java.util.*;

public class MinIndexedChar {
    public static int minIndexChar(String str, String pat){
        int[] dc = new int[256];
        Arrays.fill(dc, -1);
        for (int i = 0; i < str.length(); i++) {
            if (dc[str.charAt(i)] == -1) {
                dc[str.charAt(i)] = i;
            }
        }
        int index = Integer.MAX_VALUE;
        for (int i = 0; i < pat.length(); i++) {
            if (dc[pat.charAt(i)] >= 0) {
                index = Math.min(index, dc[pat.charAt(i)]);
            }
        }
        return index == Integer.MAX_VALUE ? -1 : index;
    }
}
