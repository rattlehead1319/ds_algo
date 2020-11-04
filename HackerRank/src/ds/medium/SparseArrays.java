package ds.medium;

import java.util.*;

public class SparseArrays {
    private static int[] matchStrings(String[] strings, String[] queries) {
        Map<String, Integer> stringCountMap = new HashMap<>();

        for (String string : strings) {
            if (stringCountMap.containsKey(string)) {
                stringCountMap.put(string, stringCountMap.get(string) + 1);
            } else {
                stringCountMap.put(string, 1);
            }
        }
        int[] output = new int[queries.length];
        for (int index = 0; index < queries.length; index++) {
            Integer count = stringCountMap.get(queries[index]);
            if (count == null) {
                count = 0;
            }
            output[index] = count;
        }
        return output;
    }

}
