package arrays.easy;

public class CountOccurencesOfAnagrams {
    int search(String pat, String txt) {
        int[] txtChars = new int[256];
        int l = 0;
        int r = 0;

        int[] patChars = new int[256];
        for (int i = 0; i < pat.length(); i++) {
            patChars[pat.charAt(i)]++;
        }

        int result = 0;
        while (r < txt.length()) {
            while (r - l != pat.length()) {
                txtChars[txt.charAt(r)]++;
                r++;
            }
            if (checkAnagram(txtChars, patChars)) {
                result++;
            }
            txtChars[txt.charAt(l)]--;
            l++;
        }

        return result;
    }

    boolean checkAnagram(int[] txtChars, int[] patChars) {
        for (int i = 0; i < txtChars.length; i++) {
            if (txtChars[i] != patChars[i]) {
                return false;
            }
        }
        return true;
    }
}
