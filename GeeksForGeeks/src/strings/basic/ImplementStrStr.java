package strings.basic;

public class ImplementStrStr {
    int strstr(String str, String target)
    {
        int n = str.length();
        int m = target.length();

        int i = 0;
        while (i < n-m+1) {
            int j = 0;
            while (j < m && i < n) {
                if (str.charAt(i) == target.charAt(j)) {
                    i++;
                    j++;
                } else {
                    break;
                }
            }
            if (j == m) {
                return i-m;
            } else {
                i++;
            }
        }
        return -1;
    }
}
