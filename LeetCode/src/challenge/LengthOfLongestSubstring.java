import java.util.*;

public class LengthOgLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.equals("")) {
            return 0;
        }
        
        Map<Character, Integer> map = new HashMap<>();
        int startIndex = 0;
        int max = Integer.MIN_VALUE;
        int i = 0;
        for (i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                System.out.println("i: " + i);
                max = Math.max(max, i - startIndex);
                if (map.get(c) >= startIndex) {
                    startIndex = map.get(c) + 1;    
                }                 
            }
            map.put(c, i);   
        }        
        max = Math.max(max, i - startIndex);
        return max;
    }
}
