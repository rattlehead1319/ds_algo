package problems.medium.graph;

import java.util.*;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(i, new ArrayList<>());
        }
        for (int[] pr: prerequisites) {
            adj.get(pr[1]).add(pr[0]);
        }

        boolean[] visited = new boolean[numCourses];
        boolean[] recursionStack = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (!visited[i] && dfs(adj, i, visited, recursionStack)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs (List<List<Integer>> adj, int v, boolean[] visited, boolean[] recursionStack) {
        visited[v] = true;
        recursionStack[v] = true;

        for (Integer u: adj.get(v)) {
            if (!visited[u] && dfs(adj, u, visited, recursionStack)) {
                return true;
            } else if (recursionStack[u]) {
                return true;
            }
        }
        recursionStack[v] = false;

        return false;
    }
}
