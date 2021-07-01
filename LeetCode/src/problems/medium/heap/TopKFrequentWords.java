package problems.medium.heap;

import java.util.*;

public class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        PriorityQueue<Helper> pq = new PriorityQueue<>(
                (a,b) -> a.count == b.count ? b.word.compareTo(a.word) : a.count - b.count
        );
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            map.put(words[i], map.getOrDefault(words[i], 0) + 1);
        }

        int i = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String word = entry.getKey();
            int count = entry.getValue();
            if (i < k) {
                pq.add(new Helper(word, count));
            } else {
                if (count > pq.peek().count ||
                        (count == pq.peek().count && word.compareTo(pq.peek().word) < 0))
                {
                    pq.poll();
                    pq.add(new Helper(word, count));
                }
            }
            i++;
        }

        List<String> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            result.add(pq.poll().word);
        }

        Collections.reverse(result);
        return result;
    }

    class Helper {
        String word;
        int count;
        Helper(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }
}
