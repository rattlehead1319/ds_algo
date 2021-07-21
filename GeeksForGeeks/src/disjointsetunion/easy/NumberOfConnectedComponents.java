package disjointsetunion.easy;

public class NumberOfConnectedComponents {
    static void unionNodes( int a, int b, int arr[], int rank1[], int n)
    {
        int aRep = find(a, arr);
        int bRep = find(b, arr);

        if (aRep == bRep) {
            return;
        }
        arr[bRep] = aRep;
    }

    //Function to determine number of connected components.
    static int findNumberOfConnectedComponents( int n, int arr[], int rank1[])
    {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (arr[i] == i) {
                count++;
            }
        }
        return count;
    }

    static int find( int x, int[] parent) {
        if(parent[x] == x) {
            return x;
        }
        parent[x] = find(parent[x], parent);
        return parent[x];
    }
}
