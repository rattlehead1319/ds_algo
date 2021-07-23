package problems.medium.strings;

import java.util.*;

public class FindAllAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (p.length() > s.length()) {
            return result;
        }

        int[] pattern = new int[26];
        for (char x : p.toCharArray()) {
            pattern[x - 'a']++;
        }

        int[] main = new int[26];
        int i = 0;
        for (; i < p.length(); i++) {
            main[s.charAt(i) - 'a']++;
        }
        if (Arrays.equals(pattern, main)) {
            result.add(i - p.length());
        }

        while (i < s.length()) {
            main[s.charAt(i) - 'a']++;
            main[s.charAt(i - p.length()) - 'a']--;
            if (Arrays.equals(pattern, main)) {
                result.add(i - p.length() + 1);
            }
            i++;
        }

        return result;
    }
}
