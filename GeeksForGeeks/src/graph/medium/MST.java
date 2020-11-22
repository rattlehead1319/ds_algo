package graph.medium;

import java.util.*;

public class MST {
    static class Helper {
        int value;
        int index;
        Helper (int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    static int spanningTree(int V, int E, ArrayList<ArrayList<Integer>> graph) {

        PriorityQueue<Helper> pq = new PriorityQueue<>((a, b) -> a.value - b.value);
        Set<Integer> finalised = new HashSet<>();
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);

        pq.add(new Helper(0, 0));
        dist[0] = 0;

        while (finalised.size() != V) {
            Helper h = pq.poll();
            int currentIndex = h.index;

            finalised.add(currentIndex);

            ArrayList<Integer> list = graph.get(currentIndex);
            for (int index = 0; index < list.size(); index++) {
                int v = list.get(index);
                if (!finalised.contains(index) && v != 0 && v < dist[index]) {
                    dist[index] = v;
                    pq.add(new Helper(v, index));
                }
            }

        }
        int mst = 0;
        for (int index = 0; index < dist.length; index++) {
            mst += dist[index];
        }
        return mst;
    }
}
