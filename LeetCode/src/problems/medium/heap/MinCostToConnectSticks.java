package problems.medium.heap;

import java.util.*;

public class MinCostToConnectSticks {
    public int connectSticks(int[] sticks) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int stick: sticks) {
            pq.add(stick);
        }

        int minCost = 0;
        while (pq.size() > 1) {
            int stick1 = pq.poll();
            int stick2 = pq.poll();
            minCost += stick1 + stick2;
            pq.add(stick1 + stick2);
        }

        return minCost;
    }
}
