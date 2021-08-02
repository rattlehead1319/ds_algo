package dynamicprogramming;

import java.util.*;

public class LongestArithmeticProgression {
    public int solve(final List<Integer> A) {
        int n = A.size();
        if (n <= 2) {
            return n;
        }
        int[] dp = new int[n];
        int result = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = 2;
            result = 2;
        }
        Collections.sort(A);
        for (int j = n-2; j >= 0; j--) {
            int i = j-1;
            int k = j+1;
            while (i >= 0 && k < n) {
                if (A.get(i) + A.get(k) == 2 * A.get(j)) {
                    dp[j] = Math.max(dp[k] + 1, dp[j]);
                    result = Math.max(result, dp[j]);
                    i--;
                    k++;
                } else if (A.get(i) + A.get(k) < 2 * A.get(j)) {
                    k++;
                } else {
                    i--;
                }
            }
        }

        return result;
    }
}
