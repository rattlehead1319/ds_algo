package problems.medium.heap;

import java.util.*;

public class MinDeletionsToMakeCharsFreqUnique {
    public int minDeletions(String s) {
        Map<Character, Integer> letterMap = new HashMap<>();
        for (char x: s.toCharArray()) {
            letterMap.put(x, letterMap.getOrDefault(x, 0) + 1);
        }

        PriorityQueue<Integer> freqQueue = new PriorityQueue<>((a, b) -> b - a);
        for (int freq: letterMap.values()) {
            freqQueue.add(freq);
        }

        int result = 0;
        while (!freqQueue.isEmpty()) {
            int curr = freqQueue.poll();
            if (freqQueue.isEmpty()) {
                return result;
            }
            if (curr == freqQueue.peek()) {
                if (curr > 1) {
                    freqQueue.add(curr - 1);
                }
                result++;
            }
        }

        return result;
    }
}
