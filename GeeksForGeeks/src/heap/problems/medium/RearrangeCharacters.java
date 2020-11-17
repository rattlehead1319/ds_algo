package heap.problems.medium;

import java.util.*;

public class RearrangeCharacters {

    static boolean rearrangeCharacters(String str) {

        Map<Character, Integer> map = new HashMap<>();
        for (int index = 0; index < str.length(); index++) {
            char ch = str.charAt(index);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>(
                (a, b) -> Integer.compare(b.getValue(), a.getValue())
        );

        for (Map.Entry<Character, Integer> entry: map.entrySet()) {
            maxHeap.add(entry);
        }

        if (maxHeap.isEmpty()) {
            return false;
        }

        int maxCharCount = maxHeap.poll().getValue();
        int restCharsCount = 0;
        while (!maxHeap.isEmpty()) {
            restCharsCount += maxHeap.poll().getValue();
        }

        return restCharsCount >= maxCharCount;
    }
}
