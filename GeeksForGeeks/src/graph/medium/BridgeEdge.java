package graph.medium;

import java.util.*;

/**
 * Little tricky, visit again
 */

 class Graph {
     int v;   //--> no of vertices
     int e;   //--> no of edges

     ArrayList<Integer>[] edges; //--> Adjacency list

 }

public class BridgeEdge {
    public boolean isBridge(Graph adj, int s, int e) {

        adj.edges[e].remove(new Integer(s));
        adj.edges[s].remove(new Integer(e));
        boolean[] visited = new boolean[adj.v];

        dfs(adj, s, visited);
        return !visited[e];
    }

    private void dfs (Graph adj, int vertex, boolean[] visited) {
        visited[vertex] = true;

        ArrayList<Integer> list = adj.edges[vertex];
        for (Integer val: list) {
            if (!visited[val]) {
                dfs(adj, val, visited);
            }
        }
    }
}
