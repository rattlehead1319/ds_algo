package searching.basic;

import java.util.*;

public class SearchAnElement {
    static class Pair implements Comparable<Pair> {
        int value;
        int index;
        Pair (int value, int index) {
            this.value = value;
            this.index = index;
        }

        public int compareTo (Pair p) {
            return this.value - p.value;
        }
    }

    static int search(int arr[], int N, int X)
    {
        Pair[] pairs = new Pair[N];
        for (int i = 0; i < N; i++) {
            pairs[i] = new Pair(arr[i], i);
        }
        Arrays.sort(pairs);
        return bs(pairs, 0, N-1, X);
    }

    static int bs (Pair[] arr, int low, int high, int x) {
        while (low <= high) {
            int mid = (low+high)/2;
            if (arr[mid].value < x) {
                low = mid + 1;
            } else if (arr[mid].value > x) {
                high = mid - 1;
            } else {
                if (mid == 0 || arr[mid-1].value != arr[mid].value) {
                    return arr[mid].index;
                } else {
                    high = mid-1;
                }
            }
        }
        return -1;
    }
}
