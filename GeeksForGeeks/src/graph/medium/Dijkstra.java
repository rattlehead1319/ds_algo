package graph.medium;

import java.util.*;

public class Dijkstra {
    static class Helper {
        int value;
        int index;
        Helper (int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    static int[] dijkstra(ArrayList<ArrayList<Integer>> g, int src, int V)
    {
        PriorityQueue<Helper> pq = new PriorityQueue<>((a,b) -> a.value - b.value);
        int[] dist = new int[V];
        Set<Integer> finalized = new HashSet<>();

        pq.add(new Helper(0, src));
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        while (finalized.size() != V) {
            Helper h = pq.poll();
            int u = h.index;
            finalized.add(u);

            List<Integer> list = g.get(u);
            for (int index = 0; index < list.size(); index++) {
                int val = list.get(index);
                if (!finalized.contains(index) && val != 0 && dist[u] + val < dist[index]) {
                    dist[index] = Math.min(dist[index], dist[u] + val);
                    pq.add(new Helper(dist[index], index));
                }
            }
        }
        return dist;
    }
}
