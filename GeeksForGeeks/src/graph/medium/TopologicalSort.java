package graph.medium;

import java.util.*;

public class TopologicalSort {
    static int[] topoSort(ArrayList<ArrayList<Integer>> adj, int N) {
        List<Integer> result = new ArrayList<>();

        int[] indegree = new int[N];
        for (int index = 0; index < adj.size(); index++) {
            for (Integer vertex: adj.get(index)) {
                indegree[vertex]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int index = 0; index < N; index++) {
            if(indegree[index] == 0) {
                queue.add(index);
            }
        }

        while (!queue.isEmpty()) {
            Integer current = queue.poll();
            result.add(current);
            for (Integer vertex: adj.get(current)) {
                indegree[vertex]--;
                if (indegree[vertex] == 0) {
                    queue.add(vertex);
                }
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }
}
