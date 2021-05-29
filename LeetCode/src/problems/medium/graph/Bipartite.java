package problems.medium.graph;

import java.util.*;

//Good one, must visit

public class Bipartite {
    public boolean isBipartite(int[][] graph) {

        int n = graph.length;
        Stack<Integer> stack = new Stack<>();
        int[] colors = new int[n];
        Arrays.fill(colors, -1);

        for (int i = 0; i < n; i++) {
            if (colors[i] != -1) {
                continue;
            }

            stack.push(i);
            colors[i] = 0;

            while (!stack.isEmpty()) {
                int u = stack.pop();
                for (int v : graph[u]) {
                    if (colors[v] == -1) {
                        stack.push(v);
                        colors[v] = colors[u] ^ 1;
                    } else if (colors[u] == colors[v]) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
