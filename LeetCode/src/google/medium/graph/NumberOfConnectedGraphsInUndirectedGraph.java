package google.medium.graph;

import java.util.*;

public class NumberOfConnectedGraphsInUndirectedGraph {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(i, new ArrayList<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        int result = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(adj, i, visited);
                result++;
            }
        }
        return result;
    }

    private void dfs(List<List<Integer>> adj, int u, boolean[] visited) {
        visited[u] = true;
        for (Integer v : adj.get(u)) {
            if (!visited[v]) {
                dfs(adj, v, visited);
            }
        }
    }
}
