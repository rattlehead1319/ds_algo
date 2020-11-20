package graph.easy;

import java.util.*;

public class MotherVertex {
    static int findMother(ArrayList<ArrayList<Integer>> g, int n)
    {
        // visited[] is used for DFS. Initially
        // all are initialized as not visited
        boolean[] visited = new boolean[n];

        // To store last finished vertex
        // (or mother vertex)
        int v = -1;

        for(int i = 0; i < n; i++)
        {
            if (!visited[i])
            {
                DFSUtil(g, i, visited);
                v = i;
            }
        }

        // If there exist mother vertex (or vetices)
        // in given graph, then v must be one
        // (or one of them)

        // Now check if v is actually a mother
        // vertex (or graph has a mother vertex).
        // We basically check if every vertex
        // is reachable from v or not.

        // Reset all values in visited[] as false
        // and do DFS beginning from v to check
        // if all vertices are reachable from
        // it or not.
        boolean[] check = new boolean[n];
        DFSUtil(g, v, check);
        for(boolean val : check)
        {
            if (!val)
            {
                return -1;
            }
        }
        return v;
    }

    // A recursive function to print DFS starting from v
    static void DFSUtil(ArrayList<ArrayList<Integer>> g, int v, boolean[] visited) {
        // Mark the current node as
        // visited and print it
        visited[v] = true;

        // Recur for all the vertices
        // adjacent to this vertex
        for(int x : g.get(v))
        {
            if (!visited[x])
            {
                DFSUtil(g, x, visited);
            }
        }
    }
}
