package problems.medium;

import java.util.*;

public class LongestSubStringLength {
    public int lengthOfLongestSubstring(String s) {

        char[] arr = s.toCharArray();
        int result = 0;
        Set<Character> set = new HashSet<>();

        int left = 0;
        int right = 0;
        while (right < arr.length) {
            if (!set.contains(arr[right])) {
                set.add(arr[right]);
                result = Math.max(result, right-left+1);
                right++;
            } else {
                set.remove(arr[left++]);
            }
        }
        return result;
    }
}
