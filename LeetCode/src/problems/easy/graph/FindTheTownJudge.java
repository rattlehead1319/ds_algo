package problems.easy.graph;

import java.util.*;

public class FindTheTownJudge {
    public int findJudge(int n, int[][] trust) {
        if (n == 1 && (trust == null || trust.length == 0)) {
            return 1;
        }

        int[] indegree = new int[n+1];

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(i, new ArrayList<>());
        }

        for (int[] tr: trust) {
            adj.get(tr[0]).add(tr[1]);
        }

        for (int i = 1; i < adj.size(); i++) {
            for (Integer u: adj.get(i)) {
                indegree[u]++;
            }
        }

        for (int i = 0; i <= n; i++) {
            if (indegree[i] == n-1 && adj.get(i).isEmpty()) {
                return i;
            }
        }
        return -1;
    }
}
