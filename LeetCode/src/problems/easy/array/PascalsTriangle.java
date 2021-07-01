package problems.easy.array;

import java.util.*;

//Not really an array problem but donno where to put

public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> first = new ArrayList<>();
        first.add(1);
        result.add(first);

        for (int i = 1; i < numRows; i++) {
            List<Integer> prev = result.get(result.size() - 1);
            List<Integer> current = new ArrayList<>();
            current.add(1);

            if (prev.size() > 1) {
                int j = 1;
                while (j < i) {
                    int start = prev.get(j-1);
                    int end = prev.get(j);
                    current.add(start+end);
                    j++;
                }
            }

            current.add(1);
            result.add(current);
        }

        return result;
    }
}
