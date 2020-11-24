package graph.hard;

import java.util.*;

public class TarjansAlgo {
    private int time = 0;

    public void find(ArrayList<ArrayList<Integer>> adj, int N)
    {
        // Write your code here
        int[] disc = new int[N];
        int[] low = new int[N];

        for (int i = 0; i < N; i++) {
            disc[i] = -1;
            low[i] = -1;
        }

        boolean[] stackMember = new boolean[N];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            if (disc[i] == -1) {
                dfs(adj, i, disc, low, stackMember, stack);
            }
        }
    }

    private void dfs(ArrayList<ArrayList<Integer>> adj, int vertex,
                     int[] disc, int[] low, boolean[] stackMember, Stack<Integer> stack)
    {
        disc[vertex] = time;
        low[vertex] = time;
        time++;
        stackMember[vertex] = true;
        stack.push(vertex);

        for (Integer v: adj.get(vertex)) {
            if (disc[v] == -1) {
                dfs(adj, v, disc, low, stackMember, stack);
                low[vertex] = Math.min(low[vertex], low[v]);
            } else if (stackMember[v] == true) {
                low[vertex] = Math.min(low[vertex], disc[v]);
            }
        }

        int w = -1;
        List<String> list = new ArrayList<>();
        if (low[vertex] == disc[vertex]) {
            while (w != vertex) {
                w = stack.pop();
                list.add(String.valueOf(w));
                stackMember[w] = false;
            }
            System.out.print(String.join(" ", list));
            System.out.print(",");
        }
    }
}
