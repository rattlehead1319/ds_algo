package problems.medium.graph;

import java.util.*;

//Must Visit

public class NetworkDelayTime {
    static class Helper {
        int v;
        int w;
        Helper (int v, int w) {
            this.v = v;
            this.w = w;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        if (times == null || times.length == 0) {
            return 0;
        }

        List<List<Helper>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(i, new ArrayList<>());
        }

        for (int[] time : times) {
            Helper h = new Helper(time[1], time[2]);
            adj.get(time[0]).add(h);
        }

        PriorityQueue<Helper> pq = new PriorityQueue<>(
                (a,b) -> a.w - b.w
        );

        pq.add(new Helper(k, 0));
        Map<Integer,Integer> dist = new HashMap<>();

        while (!pq.isEmpty()) {
            Helper h = pq.poll();
            int u = h.v;
            int d = h.w;
            if (dist.containsKey(u)) {
                continue;
            }
            dist.put(u, d);

            for (Helper h1 : adj.get(u)) {
                int v = h1.v;
                int w = h1.w;
                if (dist.get(v) == null) {
                    pq.add(new Helper(v, d+w));
                }
            }
        }

        if (dist.size() != n) {
            return -1;
        }

        int result = 0;
        for (int val: dist.values()) {
            result = Math.max(result, val);
        }

        return result;
    }
}
