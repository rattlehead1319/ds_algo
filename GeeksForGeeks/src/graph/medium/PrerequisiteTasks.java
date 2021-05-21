package graph.medium;

import java.util.*;

public class PrerequisiteTasks {

    public boolean isPossible(int N, int[][] prerequisites)
    {

        if (prerequisites == null || prerequisites.length == 0) {
            return false;
        }

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            adj.add(i, new ArrayList<>());
        }

        for (int[] pr : prerequisites) {
            adj.get(pr[1]).add(pr[0]);
        }

        int[] visited = new int[N];
        for (int i = 0; i < N; i++) {
            if (visited[i] == 0 && isCyclic(adj, i, visited)) {
                return false;
            }
        }

        return true;
    }

    private boolean isCyclic (List<List<Integer>> adj, int v, int[] visited) {
        visited[v] = 1;
        for (Integer u : adj.get(v)) {
            if (visited[u] == 1 || isCyclic(adj, u, visited)) {
                return true;
            }
        }
        visited[v] = 2;
        return false;
    }
}
