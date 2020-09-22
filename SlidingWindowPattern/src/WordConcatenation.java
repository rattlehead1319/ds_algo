import java.util.*;

public class WordConcatenation {
    public static List<Integer> findWordConcatenation(String str, String[] words) {
        List<Integer> resultIndices = new ArrayList<>();
        int wordLength = words[0].length();

        int startIndex = 0;
        Map<String, Integer> wordMap = new HashMap<>();
        for (String word : words) {
            wordMap.put(word, 1);
        }

        int endIndex = 0;
        int matches = 0;
        while(endIndex + wordLength <= str.length()) {
            String sub = str.substring(endIndex, (endIndex + wordLength));
            if (wordMap.containsKey(sub) && wordMap.get(sub) != 0) {
                matches++;
                wordMap.put(sub, wordMap.get(sub) - 1);
            } else if (wordMap.containsKey(sub) && wordMap.get(sub) == 0) {
                startIndex = startIndex + wordLength;
            }
            if (matches == wordMap.size()) {
                resultIndices.add(startIndex);

                String startStr = str.substring(startIndex, startIndex + wordLength);
                wordMap.put(startStr, wordMap.get(startStr) + 1);
                matches--;

                startIndex = startIndex + wordLength;
            }


            endIndex = endIndex + wordLength;
        }
        return resultIndices;
    }

    public static void main(String[] args) {
        List<Integer> result = WordConcatenation.findWordConcatenation("catfoxcat", new String[] { "cat", "fox" });
        System.out.println(result);
        result = WordConcatenation.findWordConcatenation("catcatfoxfox", new String[] { "cat", "fox" });
        System.out.println(result);
    }
}