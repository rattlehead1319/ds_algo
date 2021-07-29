package dynamicprogramming.medium;

public class MaximizeCutSegments {
    public int maximizeCuts(int n, int x, int y, int z)
    {
        //return maximizeCutsRec(n, x, y, z);
        return maximizeCutsDP(n, x, y, z);
    }
    
    private int maximizeCutsRec(int n, int x, int y, int z) {
        
        if (n == 0) {
            return 0;
        }
        
        int max = -1;
        if (x <= n) {
            max = Math.max(max, maximizeCutsRec(n-x, x, y, z));
        }
        if (y <= n) {
            max = Math.max(max, maximizeCutsRec(n-y, x, y, z));
        }
        if (z <= n) {
            max = Math.max(max, maximizeCutsRec(n-z, x, y, z));
        }
        if (max != -1) {
            max++;
        }
        return max;
    }
    
    private int maximizeCutsDP(int n, int x, int y, int z) {
        int[] dp = new int[n+1];
        
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = -1;
            if (x <= i) {
                dp[i] = Math.max(dp[i], dp[i-x]);
            }
            if (y <= i) {
                dp[i] = Math.max(dp[i], dp[i-y]);
            }
            if (z <= i) {
                dp[i] = Math.max(dp[i], dp[i-z]);
            }
            if (dp[i] != -1) {
                dp[i]++;
            }
        }
        return dp[n] == -1 ? 0 : dp[n];
    }
}
