package disjointsetunion.easy;

import java.util.*;

public class MSTUsingKruskal {
    static class Edge {
        int src;
        int des;
        int wt;
    }

    static class Helper implements Comparable<Helper> {
        int src;
        int dest;
        int weight;
        Helper(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }

        @Override
        public int compareTo(Helper h) {
            return this.weight - h.weight;
        }
    }
    //Function to find the minimum spanning tree value using Kruskal.
    static long kruskalDSU(ArrayList<Edge> adj, int n, int m)
    {
        List<Helper> list = new ArrayList<>();
        for (Edge e : adj) {
            list.add(new Helper(e.src, e.des, e.wt));
        }
        Collections.sort(list);

        int[] parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        long mst = 0;
        for (Helper h: list) {
            int srcRep = find(h.src, parent);
            int destRep = find(h.dest, parent);

            if (srcRep != destRep) {
                mst += h.weight;
                parent[destRep] = srcRep;
            }
        }

        return mst;
    }

    static int find(int x, int[] parent) {
        if (parent[x] == x) {
            return x;
        }
        parent[x] = find(parent[x], parent);
        return parent[x];
    }
}
