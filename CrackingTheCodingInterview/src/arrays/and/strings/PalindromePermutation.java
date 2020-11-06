package arrays.and.strings;

import java.util.*;

/**
 * Not an optimal solution, flipping single integer bit is
 */

public class PalindromePermutation {
    static boolean checkPermutation(String str) {
        Map<String, Integer> charMap = new HashMap<>();
        for (int index = 0; index < str.length(); index++) {
            char c = str.charAt(index);
            c = Character.toLowerCase(c);
            if (!Character.isAlphabetic(c)) {
                continue;
            }
            String s = Character.toString(c);
            if (charMap.containsKey(s)) {
                charMap.put(s, charMap.get(s) + 1);
            } else {
                charMap.put(s, 1);
            }
        }

        int oddCount = 0;
        for (Integer value: charMap.values()) {
            if (value%2 != 0) {
                oddCount++;
                if (oddCount > 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(checkPermutation("Tact Coa"));
    }
}
