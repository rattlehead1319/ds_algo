package problems.medium.graph;

import java.util.*;

public class AllPathsFromSourceToDestinationDAG {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> listGraph = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            List<Integer> list = new ArrayList<>();
            for (int v : graph[i]) {
                list.add(v);
            }
            listGraph.add(i, list);
        }

        int v = graph.length;
        int source = 0;
        int target = v-1;

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> sourceVertices = listGraph.get(source);

        for (Integer vertex: sourceVertices) {
            List<Integer> current = new ArrayList<>();
            current.add(source);
            dfs(listGraph, vertex, target, current, result);
        }

        return result;
    }

    private void dfs(
            List<List<Integer>> graph,
            int vertex,
            int target,
            List<Integer> current,
            List<List<Integer>> result
    ) {

        current.add(vertex);
        if (vertex == target) {
            result.add(new ArrayList<>(current));
        }
        for (Integer u : graph.get(vertex)) {
            dfs(graph, u, target, current, result);
        }
        current.remove(current.size()-1);
    }
}
