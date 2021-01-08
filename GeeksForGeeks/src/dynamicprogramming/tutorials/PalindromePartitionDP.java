package dynamicprogramming.tutorials;

public class PalindromePartitionDP {

    private static int minCuts (String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            dp[i][i] = 0;
        }

        for (int gap = 1; gap < n; gap++) {
            for (int i = 0; i+gap < n; i++) {
                int j = i+gap;
                if (isPalindrome(s, i, j)) {
                    dp[i][j] = 0;
                } else {
                    int res = Integer.MAX_VALUE;
                    for (int k = i; k < j; k++) {
                        int x = 1 + dp[i][k] + dp[k+1][j];
                        res = Math.min(res, x);
                    }
                    dp[i][j] = res;
                }
            }
        }
        return dp[0][n-1];
    }

    private static boolean isPalindrome (String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main (String[] args) {
        System.out.println(minCuts("geek"));
        System.out.println(minCuts("abcde"));
    }
}
