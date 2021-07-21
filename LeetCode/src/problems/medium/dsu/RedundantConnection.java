package problems.medium.dsu;

public class RedundantConnection {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int[] edge : edges) {
            int aRep = find(edge[0], parent);
            int bRep = find(edge[1], parent);

            if (aRep == bRep) {
                return edge;
            }
            parent[bRep] = aRep;
        }
        return null;
    }

    private int find(int x, int[] parent) {
        if(parent[x] == x) {
            return x;
        }
        parent[x] = find(parent[x], parent);
        return parent[x];
    }
}
