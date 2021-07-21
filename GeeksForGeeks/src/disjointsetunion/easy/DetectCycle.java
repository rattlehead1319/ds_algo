package disjointsetunion.easy;

import java.util.*;

public class DetectCycle {
    public int detectCycle(int V, ArrayList<ArrayList<Integer>> adj)
    {
        int[] parent = new int[V];
        for (int i = 0; i < V; i++) {
            parent[i] = i;
        }
        int[] rank = new int[V];

        boolean[][] visited = new boolean[V][V];
        for (int u = 0; u < adj.size(); u++) {
            for (Integer v : adj.get(u)) {
                if (!visited[u][v]) {
                    int uRep = find(parent, u);
                    int vRep = find(parent, v);
                    if (uRep == vRep) {
                        return 1;
                    }
                    parent[vRep] = uRep;
                }
                visited[u][v] = true;
                visited[v][u] = true;
            }
        }

        return 0;
    }

    private int find (int[] parent, int x) {
        if (parent[x] == x) {
            return x;
        }
        parent[x] = find(parent, parent[x]);
        return parent[x];
    }
}
