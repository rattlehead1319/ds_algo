package graph.hard;

import java.util.*;

class Helper {
    String s;
    int dist;

    Helper (String s, int dist) {
        this.s = s;
        this.dist = dist;
    }
}

public class WordLadder1 {
    public int wordLadderLength(String startWord, String targetWord, String[] wordList)
    {
        if (wordList == null || wordList.length == 0 ||
                !Arrays.asList(wordList).contains(targetWord) ||
                startWord.equals(targetWord))
        {
            return 0;
        }

        Queue<Helper> queue = new LinkedList<>();
        queue.add(new Helper(startWord, 1));

        Set<String> visited = new HashSet<>();
        visited.add(startWord);

        while (!queue.isEmpty()) {
            Helper h = queue.poll();
            String curr = h.s;
            int dist = h.dist;

            for (int i = 0; i < wordList.length; i++) {
                String word = wordList[i];
                if (!visited.contains(word)) {
                    if (hasOneCharDiff(curr, word)) {
                        if (word.equals(targetWord)) {
                            return dist + 1;
                        }
                        queue.add(new Helper(word, dist + 1));
                        visited.add(word);
                    }
                }
            }
        }

        return 0;
    }

    private boolean hasOneCharDiff(String a, String b) {
        int count = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                count++;
                if (count > 1) {
                    return false;
                }
            }
        }
        return count == 1;
    }
}
