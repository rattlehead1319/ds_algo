package problems.medium.graph;

import java.util.*;

public class KeysAndRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {

        if (rooms == null || rooms.size() == 0) {
            return false;
        }

        int n = rooms.size();
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(i, new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            List<Integer> keys = rooms.get(i);
            for (int key : keys) {
                adj.get(i).add(key);
            }
        }

        int count = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(adj, i, visited);
                count++;
            }
        }

        return count == 1;
    }

    private void dfs (List<List<Integer>> adj, int v, boolean[] visited) {
        visited[v] = true;
        for (Integer u: adj.get(v)) {
            if (!visited[u]) {
                dfs(adj, u, visited);
            }
        }
    }
}
