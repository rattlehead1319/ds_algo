package ds.easy.array;

import java.util.*;

public class DynamicArray {
    public static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
        List<List<Integer>> results = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            results.add(new ArrayList());
        }
        List<Integer> output = new ArrayList<>();
        int lastAnswer = 0;
        for (List<Integer> query: queries) {
            int task = query.get(0);
            int x = query.get(1);
            int y = query.get(2);

            int seqIndex = (x ^ lastAnswer) % n;
            if (task == 1) {
                results.get(seqIndex).add(y);
            } else if (task == 2) {
                int seqSize = results.get(seqIndex).size();
                int index = y%seqSize;
                int value = results.get(seqIndex).get(index);
                lastAnswer = value;
                output.add(lastAnswer);
            }
        }
        return output;
    }
}
