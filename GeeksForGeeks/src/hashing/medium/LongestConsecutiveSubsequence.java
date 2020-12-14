package hashing.medium;

import java.util.*;

public class LongestConsecutiveSubsequence {
    static int findLongestConseqSubseq(int arr[], int N)
    {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            set.add(arr[i]);
        }

        int res = 0;
        for (int i = 0; i < N; i++) {
            if (!set.contains(arr[i] - 1)) {
                int curr = arr[i];
                int count = 0;
                while (set.contains(curr)) {
                    curr++;
                    count++;
                }
                res = Math.max(res, count);
            }
        }
        return res;
    }
}
