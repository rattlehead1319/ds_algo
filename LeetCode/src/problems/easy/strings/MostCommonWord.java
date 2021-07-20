package problems.easy.strings;

import java.util.*;

public class MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {
        Map<String, Integer> wordCount = new HashMap<>();
        Set<String> bannedWords = new HashSet();
        for (String word: banned) {
            bannedWords.add(word);
        }

        String[] words = paragraph.split(" ");
        int maxCount = Integer.MIN_VALUE;
        String result = "";

        for (String word: words) {
            word = removePunctuations(word);
            if (bannedWords.contains(word)) {
                continue;
            }
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
            int count = wordCount.get(word);
            if (count > maxCount) {
                maxCount = count;
                result = word;
            }
        }
        return result;
    }

    private String removePunctuations(String s) {
        s = s.toLowerCase();
        String punc = "!?',;.";
        for (int i = 0; i < s.length(); i++) {
            char x = s.charAt(i);
            if (punc.indexOf(x) != -1) {
                return s.substring(0,i);
            }
        }
        return s;
    }
}
