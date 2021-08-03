package arrays.easy;

import java.util.*;

public class MountainSubArrayProblem {
    class Pair {
        int l, r;
        Pair(int l, int r) {
            this.l = l;
            this.r = r;
        }
    }

    public ArrayList<Boolean> processQueries(int[] a, int n, ArrayList<Pair> queries,
                                             int q) {

        int[] left = new int[n];
        int[] right = new int[n];
        preprocess(a, left, right);
        ArrayList<Boolean> result = new ArrayList<>();
        for (Pair pair: queries) {
            if (right[pair.l] >= left[pair.r]) {
                result.add(true);
            } else {
                result.add(false);
            }
        }

        return result;
    }

    private void preprocess(int[] a, int[] left, int[] right) {
        int leftMax = 0;
        int n = a.length;
        left[0] = 0;
        for (int i = 1; i < n; i++) {
            if (a[i] > a[i - 1]) {
                leftMax = i;
            }
            left[i] = leftMax;
        }

        int rightMax = n - 1;
        right[n - 1] = n - 1;
        for (int i = n - 2; i >= 0; i--) {
            if (a[i] > a[i + 1]) {
                rightMax = i;
            }
            right[i] = rightMax;
        }
    }
}
