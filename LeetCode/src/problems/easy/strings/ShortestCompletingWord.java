package problems.easy.strings;

public class ShortestCompletingWord {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        String result = "";
        int minLength = Integer.MAX_VALUE;
        for (String word: words) {
            int[] chars = new int[26];
            for (char x : licensePlate.toCharArray()) {
                if (Character.isAlphabetic(x)) {
                    int c = Character.toLowerCase(x) - 'a';
                    chars[c]++;
                }
            }
            for (char x : word.toCharArray()) {
                int c = Character.toLowerCase(x) - 'a';
                chars[c]--;
            }
            int k;
            for (k = 0; k < 26; k++) {
                if (chars[k] > 0) {
                    break;
                }
            }
            if (k == 26 && word.length() < minLength) {
                minLength = word.length();
                result = word;
            }
        }

        return result;
    }
}
