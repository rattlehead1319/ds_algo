package slidingwindowpattern;

import java.util.*;

public class StringAnagram {

    public static List<Integer> findStringAnagrams(String str, String pattern) {
        List<Integer> resultIndices = new ArrayList<>();
        int startIndex = 0;
        Map<Character, Integer> charMap = new HashMap<>();

        for (Character c : pattern.toCharArray()) {
            charMap.put(c, charMap.getOrDefault(c, 0) + 1);
        }

        int matches = 0;
        for (int endIndex = 0; endIndex < str.length(); endIndex++) {
            char rightChar = str.charAt(endIndex);

            if (charMap.containsKey(rightChar)) {
                Integer count  = charMap.get(rightChar);
                charMap.put(rightChar, --count);

                if (charMap.get(rightChar) == 0) {
                    matches++;
                }
            }

            if (matches == charMap.size()) {
                resultIndices.add(startIndex);
            }

            if (endIndex >= pattern.length() - 1) {
                char leftChar = str.charAt(startIndex++);

                Integer count = charMap.get(leftChar);
                if (count == 0) {
                    matches--;
                }
                charMap.put(leftChar, ++count);
            }
        }

        return resultIndices;
    }

    public static void main(String[] args) {
        System.out.println(StringAnagram.findStringAnagrams("ppqp", "pq"));
        System.out.println(StringAnagram.findStringAnagrams("abbcabc", "abc"));
    }
}
