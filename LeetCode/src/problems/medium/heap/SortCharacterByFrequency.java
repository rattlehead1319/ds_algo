package problems.medium.heap;

import java.util.*;

public class SortCharacterByFrequency {
    class Helper {
        char letter;
        int count;
        Helper(char letter, int count) {
            this.letter = letter;
            this.count = count;
        }
    }

    public String frequencySort(String s) {
        Map<Character, Integer> frequency = new HashMap<>();
        for (char x: s.toCharArray()) {
            frequency.put(x, frequency.getOrDefault(x, 0) + 1);
        }

        //Below is Bucket Sort algorithm which is supposed to be running in O(n) time
        //but on leetcode it takes more time than priorityQueue which can be because of
        //data not being uniformly distributed
        int maxFrequency = Collections.max(frequency.values());
        List<List<Character>> buckets = new ArrayList<>();
        for (int i = 0; i <= maxFrequency; i++) {
            buckets.add(i, new ArrayList<>());
        }

        for (Character key: frequency.keySet()) {
            buckets.get(frequency.get(key)).add(key);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = buckets.size() - 1; i >= 0; i--) {
            for (Character c: buckets.get(i)) {
                for (int j = 0; j < i; j++) {
                    sb.append(c);
                }
            }

        }

        return sb.toString();

//         PriorityQueue<Helper> pq = new PriorityQueue<>((a,b) -> b.count - a.count);
//         for (Map.Entry<Character, Integer> entry: frequency.entrySet()) {
//             pq.add(new Helper(entry.getKey(), entry.getValue()));
//         }

//         StringBuilder result = new StringBuilder();
//         while (!pq.isEmpty()) {
//             Helper curr = pq.poll();
//             for (int i = 0; i < curr.count; i++) {
//                 result.append(curr.letter);
//             }
//         }

//         return result.toString();
    }
}
