package problems.medium.heap;

import java.util.*;

public class LeastNumberOfUniqueIntegers {
    class Solution {
        public int findLeastNumOfUniqueInts(int[] arr, int k) {

            Map<Integer, Integer> map = new HashMap<>();
            for (int x : arr) {
                map.put(x, map.getOrDefault(x, 0) + 1);
            }
            PriorityQueue<Helper> pq = new PriorityQueue<>(
                    (a,b) -> a.count - b.count
            );
            for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
                pq.add(new Helper(entry.getValue(), entry.getKey()));
            }

            while (k > 0 && !pq.isEmpty()) {
                Helper h = pq.poll();
                if (h.count > k) {
                    pq.add(new Helper(h.count - k, h.element));
                }
                k -= h.count;
            }

            return pq.size();
        }

        class Helper {
            int count;
            int element;
            Helper (int count, int element) {
                this.count = count;
                this.element = element;
            }
        }
    }
}
