package dynamicprogramming;

import java.util.*;

public class LengthOfLongestBitonicSubsequence {
    public int longestSubsequenceLength(final List<Integer> A) {
        int n = A.size();
        if (n <= 1) {
            return n;
        }
        int[] lis = new int[n];
        lis[0] = 1;

        for (int i = 1; i < n; i++) {
            lis[i] = 1;
            for (int j = 0; j < i; j++) {
                if (A.get(i) > A.get(j)) {
                    lis[i] = Math.max(lis[i], lis[j] + 1);
                }
            }
        }

        int[] lds = new int[n];
        lds[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            lds[i] = 1;
            for (int j = n - 1; j > i; j--) {
                if (A.get(i) > A.get(j)) {
                    lds[i] = Math.max(lds[i], lds[j] + 1);
                }
            }
        }

        int result = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            result = Math.max(result, lis[i] + lds[i] - 1);
        }

        return result;
    }
}
