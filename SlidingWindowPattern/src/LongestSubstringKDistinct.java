import java.util.*;

public class LongestSubstringKDistinct {

    public static int findLength(String str, int k) {
        int winStart = 0;
        Map<Character, Integer> charMap = new HashMap<>();
        char[] strArr = str.toCharArray();
        int maxLength = 0;
        for (int winEnd = 0; winEnd < strArr.length; winEnd++) {
            char rightChar = str.charAt(winEnd);
            charMap.put(rightChar, charMap.getOrDefault(rightChar, 0) + 1);

            while (charMap.size() > k) {
                char leftChar = str.charAt(winStart);
                int leftCharCount = charMap.get(leftChar);
                leftCharCount--;
                if (leftCharCount == 0) {
                    charMap.remove(leftChar);
                } else {
                    charMap.put(leftChar, --leftCharCount);
                }
                winStart++;
            }
            maxLength = Math.max(maxLength, winEnd - winStart + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("araaci", 2));
        System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("araaci", 1));
        System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("cbbebi", 3));
    }
}
