package graph.medium;

import java.util.*;

class Helper {
    int count = 0;
}

public class NoOfPathsBetween2Vertices {
    static int countPaths(ArrayList<ArrayList<Integer>> g, int s, int d) {
        if (s == d) {
            return 1;
        }
        Helper helper = new Helper();
        dfs(g, s, d, helper);
        return helper.count;
    }

    static void dfs(ArrayList<ArrayList<Integer>> g, int s, int d, Helper helper) {
        for (Integer vertex: g.get(s)) {
            if (vertex == d) {
                helper.count++;
            }
            dfs(g, vertex, d, helper);
        }
    }
}
