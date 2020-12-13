package strings.medium;

public class LexicographicRanking {
    static int findRank(String S)
    {
        int[] dc = new int[256];
        int n = S.length();

        for (int i = 0; i < n; i++) {
            if (dc[S.charAt(i)] > 0) {
                return 0;
            }
            dc[S.charAt(i)]++;
        }

        for (int i = 1; i < dc.length; i++) {
            dc[i] = dc[i] + dc[i-1];
        }

        long fact = getFact(n);
        long result = 1;
        for (int i = 0; i < n-1; i++) {
            fact = fact/(n-i);
            result += fact*dc[S.charAt(i) - 1];

            for (int j = S.charAt(i); j < 256; j++) {
                dc[j]--;
            }
        }

        return (int) (result % 1000000007L);
    }

    static long getFact(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * getFact(n-1);
    }
}
