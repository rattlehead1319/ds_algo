package problems.easy.strings;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        int[] chars = new int[26];
        for (char x : s.toCharArray()) {
            chars[x - 'a']++;
        }
        for (char x : t.toCharArray()) {
            chars[x - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (chars[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
