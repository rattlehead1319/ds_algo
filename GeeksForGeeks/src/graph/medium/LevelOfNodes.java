package graph.medium;

import java.util.*;

public class LevelOfNodes {
    static int levels(ArrayList<ArrayList<Integer>> list, int x, int in)
    {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[list.size()];
        int[] level = new int[list.size()];

        queue.add(x);
        visited[x] = true;
        level[x] = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            if (current == in) {
                return level[current];
            }
            for (Integer vertex: list.get(current)) {
                if(!visited[vertex]) {
                    queue.add(vertex);
                    visited[vertex] = true;
                    level[vertex] = level[current] + 1;
                }
            }
        }
        return -1;
    }
}
