package graph.medium;

import java.util.*;

public class DetectCyclicDirected {
    static boolean isCyclic(ArrayList<ArrayList<Integer>> adj, int V)
    {
        boolean[] visited = new boolean[V+1];
        boolean[] recursionStack = new boolean[V+1];

        for (int index = 0; index < adj.size(); index++) {
            if (!visited[index]) {
                if (isCyclicRec(adj, index, visited, recursionStack)) {
                    return true;
                }
            }
        }
        return false;
    }

    static boolean isCyclicRec(ArrayList<ArrayList<Integer>> adj, int vertex, boolean[] visited, boolean[] recursionStack) {
        visited[vertex] = true;
        recursionStack[vertex] = true;
        for (Integer val: adj.get(vertex)) {
            if (!visited[val]) {
                if (isCyclicRec(adj, val, visited, recursionStack)) {
                    return true;
                }
            } else if (recursionStack[val]) {
                return true;
            }
        }
        recursionStack[vertex] = false;
        return false;
    }
}
