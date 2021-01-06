package problems.medium;

import java.util.*;

public class FruitsInBasket {
    public int totalFruit(int[] tree) {
        Map<Integer, Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        int result = Integer.MIN_VALUE;

        while (j < tree.length) {
            if (map.size() <= 2) {
                map.put(tree[j], j++);
            }

            if (map.size() > 2) {
                int min = tree.length;
                for (int value: map.values()) {
                    min = Math.min(min, value);
                }

                i = min+1;
                map.remove(tree[min]);
            }
            result = Math.max(result, j-i);
        }
        return result;
    }
}
