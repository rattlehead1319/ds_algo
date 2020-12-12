package contest.easy;

public class CountConsistentStrings {
    public int countConsistentStrings(String allowed, String[] words) {
        int[] dc = new int[256];
        for (int i = 0; i < allowed.length(); i++) {
            dc[allowed.charAt(i)]++;
        }
        int count = 0;
        for (String word: words) {
            int i = 0;
            for (i = 0; i < word.length(); i++) {
                if (dc[word.charAt(i)] == 0) {
                    break;
                }
            }
            if (i == word.length()) {
                count++;
            }
        }
        return count;
    }
}
