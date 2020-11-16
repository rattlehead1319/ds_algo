package heap.tutorials;

import java.util.*;

class Pair {
    int diff;
    int index;
    Pair (int diff, int index) {
        this.diff = diff;
        this.index = index;
    }
}

public class KClosestElems {

    private void findCLosestElems (int[] arr, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(k, (a, b) -> Integer.compare(b.diff, a.diff));

        int index = 0;
        for (index = 0; index < k; index++) { //O(klogk)
            int val = arr[index];
            pq.add(new Pair(Math.abs(k - val), index));
        }

        while (index < arr.length) { //O(n-k(logk))
            if (Math.abs(arr[index] - k) < pq.peek().diff) {
                pq.poll();
                pq.add(new Pair(Math.abs(arr[index] - k), index));
            }
            index++;
        }

        while (!pq.isEmpty()) { //O(klogk)
            System.out.println(arr[pq.poll().index] + " ");
        }

    }
}
