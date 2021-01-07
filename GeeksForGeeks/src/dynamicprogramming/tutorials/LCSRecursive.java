package dynamicprogramming.tutorials;

public class LCSRecursive {
    public static int lcs (String s1, String s2, int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        if (s1.charAt(m-1) == s2.charAt(n-1)) {
            return 1 + lcs(s1, s2, m - 1, n - 1);
        }
       return Math.max(
               lcs(s1, s2, m, n-1),
               lcs(s1, s2, m-1, n)
       );
    }

    public static void main (String[] args) {
        System.out.println(lcs("ABCDGH", "AEDFHR", 6, 6));
    }
}
