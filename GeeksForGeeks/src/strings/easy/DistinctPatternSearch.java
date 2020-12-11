package strings.easy;

public class DistinctPatternSearch {
    static boolean search(String pat, String txt)
    {
        int n = txt.length();
        int m = pat.length();

        int i = 0;
        while (i < n) {
            int j = 0;
            while (j < m && i < n) {
                if (txt.charAt(i) == pat.charAt(j)) {
                    i++;
                    j++;
                } else {
                    break;
                }
            }
            if (j == m) {
                return true;
            } else {
                i++;
            }
        }
        return false;
    }
}
