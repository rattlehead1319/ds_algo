package graph.medium;

import java.util.*;

class Pair implements Comparable<Pair> {
    int key;
    int value;

    Pair(int key, int value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public int compareTo (Pair p) {
        return this.key - p.key;
    }
}

public class MinSwapsToSort {
    public int minSwaps(int nums[])
    {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;

        List<Pair> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new Pair(nums[i], i));
        }

        Collections.sort(list);

        int swaps = 0;
        boolean visited[] = new boolean[n];
        for (int i = 0; i < n; i++) {

            int cycleSize = 0;
            int j = i;
            while (!visited[j]) {
                visited[j] = true;

                j = list.get(j).value;
                cycleSize++;
            }

            if (cycleSize > 0) {
                swaps += cycleSize - 1;
            }
        }

        return swaps;
    }
}
