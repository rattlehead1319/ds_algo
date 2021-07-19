package problems.medium.heap;

import java.util.*;

public class TopKFrequentElements {
    class Helper {
        int num;
        int count;
        Helper (int num, int count) {
            this.num = num;
            this.count = count;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Helper> pq = new PriorityQueue<>(
                (a, b) -> a.count - b.count
        );

        Set<Integer> keys = map.keySet();
        List<Integer> elems = new ArrayList<>(keys);
        int j = 0;

        for (; j < elems.size(); j++) {
            int elem = elems.get(j);
            pq.add(new Helper(elem, map.get(elem)));
            if (j == k - 1) {
                break;
            }
        }
        j++;
        while (j < elems.size()) {
            int elem = elems.get(j);
            int count = map.get(elem);
            if (!pq.isEmpty() && count > pq.peek().count) {
                pq.poll();
                pq.add(new Helper(elem, count));
            }
            j++;
        }

        int[] result = new int[pq.size()];
        int resultIndex = pq.size() - 1;
        while (!pq.isEmpty()) {
            result[resultIndex--] = pq.poll().num;
        }

        return result;
    }
}
