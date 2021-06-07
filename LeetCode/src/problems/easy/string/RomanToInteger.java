package problems.easy.string;

import java.util.*;

public class RomanToInteger {
    public int romanToInt(String s) {

        int result = 0;
        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);

        map.put("IV", 4);
        map.put("IX", 9);
        map.put("XL", 40);
        map.put("XC", 90);
        map.put("CD", 400);
        map.put("CM", 900);

        for (int i = s.length() - 1; i >= 0; i--) {
            if (i - 1 >= 0 && map.get(s.substring(i-1, i+1)) != null) {
                result += map.get(s.substring(i-1, i+1));
                i--;
            } else {
                result += map.get(s.substring(i, i+1));
            }
        }

        return result;

    }
}
