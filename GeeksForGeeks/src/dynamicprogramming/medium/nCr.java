package dynamicprogramming.medium;

/**
 * Visit Again
 */

public class nCr {
    public static int nCrModp(int n, int r){
        if (r > n) {
            return 0;
        }

        if (r > n-r) {
            r = n-r;
        }

        int[] dp = new int[r+1];
        dp[0] = 1;

        for (int i = 0; i <= n; i++) {
            for (int j = Math.min(i, r); j > 0; j--) {
                dp[j] = (dp[j] + dp[j-1]) % 1000000007;
            }
        }
        return dp[r];
    }

//    public static void main (String[] args) {
//        String s = "abcd";
//        s += "e";
//        System.out.println(s);
//        s = s.substring(0, s.length() - 1);
//        System.out.println(s);
//    }
}
