package problems.medium.recursion;

import java.util.*;

//Better solution will be dp based

public class MaxLengthOfAConcatenatedString {
    private int result = 0;

    public int maxLength(List<String> arr) {
        maxLengthRecursive(arr, -1, "");
        return result;
    }

    private void maxLengthRecursive(List<String> arr, int index, String curr) {
        if (index == arr.size()) {
            return;
        }

        for (int i = index + 1; i < arr.size(); i++) {
            boolean areUniques = (curr.isEmpty() && hasUniqueChars(arr.get(i))) || hasUniqueChars(curr, arr.get(i));
            String currCopy = curr;
            if (areUniques) {
                curr += arr.get(i);
                result = Math.max(result, curr.length());
            }
            maxLengthRecursive(arr, i, curr);
            if (areUniques) {
                curr = currCopy;
            }
        }
    }

    private boolean hasUniqueChars(String s) {
        int[] chars = new int[26];
        for (char x: s.toCharArray()) {
            chars[x - 'a']++;
            if (chars[x - 'a'] > 1) {
                return false;
            }
        }
        return true;
    }

    private boolean hasUniqueChars(String s1, String s2) {
        int[] chars = new int[26];
        for (char x: s1.toCharArray()) {
            chars[x - 'a']++;
            if (chars[x - 'a'] > 1) {
                return false;
            }
        }
        for (char x: s2.toCharArray()) {
            if (chars[x - 'a'] > 0) {
                return false;
            } else {
                chars[x - 'a']++;
            }
        }
        return true;
    }
}
