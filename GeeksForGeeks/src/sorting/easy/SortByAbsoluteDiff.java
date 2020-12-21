package sorting.easy;

import java.util.*;

public class SortByAbsoluteDiff {
    static class Pair implements Comparable<Pair> {
        int value;
        int diff;
        int index;
        Pair (int value, int diff, int index) {
            this.value = value;
            this.diff = diff;
            this.index = index;
        }

        public int compareTo (Pair p) {
            if (this.diff ==  p.diff) {
                return this.index - p.index;
            }
            return this.diff - p.diff;
        }
    }

    static void sortABS(int arr[], int n,int k)
    {
        Pair[] pairs = new Pair[n];
        for (int i = 0; i < n; i++) {
            Pair p = new Pair(arr[i], Math.abs(k-arr[i]), i);
            pairs[i] = p;
        }
        Arrays.sort(pairs);

        for (int i = 0; i < n; i++) {
            System.out.print(pairs[i].value + " ");
        }
    }
}
