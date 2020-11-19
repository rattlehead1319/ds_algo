package graph.medium;

import java.util.*;

public class DetectCycleInUndirected {
    static boolean isCyclic(ArrayList<ArrayList<Integer>> g, int V)
    {
        boolean[] visited = new boolean[V+1];
        for (int index = 0; index < g.size(); index++) {
            if (!visited[index]) {
                if (isCyclicRec(g, index, visited, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    static boolean isCyclicRec(ArrayList<ArrayList<Integer>> g, int u, boolean[] visited, int parent) {
        visited[u] = true;
        for (Integer v: g.get(u)) {
            if (!visited[v]) {
                if (isCyclicRec(g, v, visited, u)) {
                    return true;
                }
                //Uses the fact that caller(parent) are the ones which have been visited already,
                //if not then cycle exists... caller and adjacent vertices of v since its undirected
            } else if (v != parent) {
                return true;
            }
        }
        return false;
    }
}
