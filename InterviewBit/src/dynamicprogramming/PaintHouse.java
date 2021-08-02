package dynamicprogramming;

import java.util.*;

public class PaintHouse {
    public int solve(ArrayList<ArrayList<Integer>> A) {
        int size = A.size();
        int[][] dp = new int[size][3];

        for (int j = 0; j < 3; j++) {
            dp[0][j] = A.get(0).get(j);
        }

        for (int i = 1; i < size; i++) {
            for (int j = 0; j < 3; j++) {
                int minCost = 0;
                if (j == 0) {
                    minCost = Math.min(dp[i-1][1], dp[i-1][2]);
                } else if (j == 1) {
                    minCost = Math.min(dp[i-1][0], dp[i-1][2]);
                } else {
                    minCost = Math.min(dp[i-1][0], dp[i-1][1]);
                }
                dp[i][j] = minCost + A.get(i).get(j);
            }
        }
        int result = Integer.MAX_VALUE;
        for (int j = 0; j < 3; j++) {
            result = Math.min(result, dp[size-1][j]);
        }

        return result;
    }
}
