package graph.hard;

import java.util.*;

public class NumberOfProvinces {
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {

        if (adj == null || adj.isEmpty()) {
            return 0;
        }

        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjList.add(i, new ArrayList<>());
        }

        for (int i = 0; i < V; i++) {
            ArrayList<Integer> list = adj.get(i);
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j) == 1) {
                    adjList.get(i).add(j);
                }
            }
        }

        boolean[] visited = new boolean[V];
        int result = 0;
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(adjList, i, visited);
                result++;
            }
        }

        return result;
    }

    static void dfs(List<List<Integer>> adj, int u, boolean[] visited) {
        visited[u] = true;
        for (Integer v : adj.get(u)) {
            if (!visited[v]) {
                dfs(adj, v, visited);
            }
        }
    }
}
