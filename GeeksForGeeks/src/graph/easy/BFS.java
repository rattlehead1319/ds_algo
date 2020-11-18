package graph.easy;

import java.util.*;

public class BFS {
    static ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> g, int N) {

        ArrayList<Integer> result = new ArrayList<>();
        if (g.size() == 0 || g.get(0).size() == 0) {
            return result;
        }

        boolean[] visited = new boolean[N];
        Queue<Integer> queue = new LinkedList<>();

        queue.add(0);
        visited[0] = true;

        while (!queue.isEmpty()) {
            Integer value = queue.poll();
            result.add(value);

            for (Integer vertex: g.get(value)) {
                if (!visited[vertex]) {
                    visited[vertex] = true;
                    queue.add(vertex);
                }
            }
        }

        return result;
    }
}
