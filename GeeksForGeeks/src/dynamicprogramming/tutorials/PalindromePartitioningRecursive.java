package dynamicprogramming.tutorials;

public class PalindromePartitioningRecursive {

    private static int minCuts (String s, int i, int j) {
        if (isPalindrome(s, i, j)) {
            return 0;
        }

        int res = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int x = 1 + minCuts(s, i, k) + minCuts(s, k+1, j);
            res = Math.min(res, x);
        }
        return res;
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
        System.out.println(minCuts("geek", 0, 3));
        System.out.println(minCuts("abcde", 0, 4));
    }
}
