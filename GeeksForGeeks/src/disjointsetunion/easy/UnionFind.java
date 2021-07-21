package disjointsetunion.easy;

public class UnionFind {
    public void union_(int a, int b, int parent[], int rank[])
    {
        int aRep = find(a, parent);
        int bRep = find(b, parent);

        if (aRep == bRep) {
            return;
        }

        if (rank[aRep] < rank[bRep]) {
            parent[aRep] = bRep;
        } else if (rank[aRep] > rank[bRep]) {
            parent[bRep] = aRep;
        } else {
            parent[bRep] = aRep;
            rank[aRep]++;
        }
    }

    //Function to check whether 2 nodes are connected or not.
    public Boolean isConnected(int a, int b, int par[], int rank[])
    {
        int aRep = find(a, par);
        int bRep = find(b, par);

        return aRep == bRep;
    }

    private int find(int x, int[] parent) {
        if (parent[x] == x) {
            return x;
        }
        return find(parent[x], parent);
    }
}
