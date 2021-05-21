package problems.medium.graph;

import java.util.*;

public class CourseSchedule2 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(i, new ArrayList<>());
        }

        for (int[] pr: prerequisites) {
            adj.get(pr[1]).add(pr[0]);
        }

        List<Integer> result = new LinkedList<>();
        int[] visited = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0 && dfs(adj, i, visited, result)) {
                return new int[0];
            }
        }
        Collections.reverse(result);
        return result.stream().mapToInt(i -> i).toArray();
    }

    private boolean dfs (List<List<Integer>> adj, int v, int[] visited, List<Integer> result) {
        visited[v] = 1;
        for (Integer u : adj.get(v)) {
            if (visited[u] == 0 && dfs(adj, u, visited, result)) {
                return true;
            }
            if (visited[u] == 1) {
                return true;
            }
        }
        visited[v] = 2;
        result.add(v);
        return false;
    }
}
