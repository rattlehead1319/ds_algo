package problems.medium.graph;

import java.util.*;

//Must visit

public class MinHeightDelete {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        List<Integer> result = new ArrayList<>();
        if (n == 1 && (edges == null || edges.length == 0)) {
            result.add(0);
            return result;
        }

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(i, new ArrayList<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (adj.get(i).size() == 1) {
                queue.add(i);
            }
        }

        int vertices = n;
        while (vertices > 2) {
            int qSize = queue.size();
            for (int i = 0; i < qSize; i++) {
                Integer v = queue.poll();
                vertices--;
                int u = adj.get(v).get(0);

                adj.set(v, null);
                adj.get(u).remove(v);

                if (adj.get(u).size() == 1) {
                    queue.add(u);
                }
            }
        }

        while (!queue.isEmpty()) {
            result.add(queue.poll());
        }

        return result;
    }
}
