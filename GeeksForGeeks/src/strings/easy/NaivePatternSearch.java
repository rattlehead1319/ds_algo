package strings.easy;

//This is basically approach for Distinct..
//Naive is to increment i by 1 no matter what

public class NaivePatternSearch {
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
