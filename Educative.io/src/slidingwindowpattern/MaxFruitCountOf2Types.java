package slidingwindowpattern;

import java.util.*;

public class MaxFruitCountOf2Types {

    public static int findLength(char[] arr) {

        Map<Character, Integer> fruitMap = new HashMap<>();
        int start = 0;
        int maxFruits = 0;
        for (int end =0 ; end < arr.length; end++) {
            fruitMap.put(arr[end], fruitMap.getOrDefault(arr[end], 0) + 1);
            while (fruitMap.size() > 2) {
                int count = fruitMap.get(arr[start]);
                count--;
                if (count == 0) {
                    fruitMap.remove(arr[start]);
                } else {
                    fruitMap.put(arr[start], count);
                }
                start++;
            }
            maxFruits = Math.max(maxFruits, end - start + 1);
        }
        return maxFruits;
    }

    public static void main(String[] args) {
        System.out.println("Maximum number of fruits: " +
                MaxFruitCountOf2Types.findLength(new char[] { 'A', 'B', 'C', 'A', 'C' }));
        System.out.println("Maximum number of fruits: " +
                MaxFruitCountOf2Types.findLength(new char[] { 'A', 'B', 'C', 'B', 'B', 'C' }));
    }
}
