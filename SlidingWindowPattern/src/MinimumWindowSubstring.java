import java.util.*;

public class MinimumWindowSubstring {

    public static String findSubstring(String str, String pattern) {
        Map<Character, Integer> charMap = new HashMap<>();
        for (char c : pattern.toCharArray()) {
            charMap.put(c, charMap.getOrDefault(c, 0) + 1);
        }
        int startIndex = 0;
        int matches = 0;
        for (int endIndex = 0; endIndex < str.length(); endIndex++) {
            char rightChar = str.charAt(endIndex);

            int count = Integer.MAX_VALUE;
            if (charMap.containsKey(rightChar)) {
                count = charMap.get(rightChar);
                charMap.put(rightChar, --count);

                if (count == 0) {
                    matches++;
                }
            }
            if (matches == pattern.length()) {
                return str.substring(startIndex, endIndex + 1);
            }

            if (count < 0) {
                while (startIndex < endIndex) {
                    char leftChar = str.charAt(startIndex);
                    if (charMap.containsKey(leftChar)) {
                        if (charMap.get(leftChar) == 0) {
                            matches--;
                        }
                        charMap.put(leftChar, charMap.get(leftChar) + 1);
                    }
                    startIndex++;
                }
            }
        }
        return "";
    }

    public static void main(String[] args) {
        System.out.println(MinimumWindowSubstring.findSubstring("aabdec", "abc"));
        System.out.println(MinimumWindowSubstring.findSubstring("abdabca", "abc"));
        System.out.println(MinimumWindowSubstring.findSubstring("adcad", "abc"));
    }
}


//Input: String="aabdec", Pattern="abc"
//Output: "abdec"
//Input: String="abdabca", Pattern="abc"
//Output: "abc"
//Input: String="adcad", Pattern="abc"
//Output: ""