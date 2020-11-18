package graph.easy;

import java.util.*;

public class DFS {
    static ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> g, int N)
    {
        ArrayList<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[N];
        dfsRec(g, 0, visited, result);
        return result;
    }

    static void dfsRec(ArrayList<ArrayList<Integer>> g, int n, boolean[] visited, ArrayList<Integer> result) {
        visited[n] = true;
        result.add(n);

        for (Integer vertex: g.get(n)) {
            if (!visited[vertex]) {
                dfsRec(g, vertex, visited, result);
            }
        }
    }
}
