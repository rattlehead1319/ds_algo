package problems.medium.hashing;

import java.util.*;

public class IntegerToRoman {
    public String intToRoman(int num) {

        TreeMap<Integer, String> map = new TreeMap<>();
        map.put(1, "I");
        map.put(5, "V");
        map.put(10, "X");
        map.put(50, "L");
        map.put(100, "C");
        map.put(500, "D");
        map.put(1000, "M");

        map.put(4, "IV");
        map.put(9, "IX");
        map.put(40, "XL");
        map.put(90, "XC");
        map.put(400, "CD");
        map.put(900, "CM");

        String result = "";
        while (num > 0) {
            int key = map.floorKey(num);
            result += map.get(key);

            num -= key;
        }

        return result;
    }
}
