package graph.medium;

import java.util.*;
import java.io.*;
import java.lang.*;

public class Kosaraju {
    public int kosaraju(ArrayList<ArrayList<Integer>> adj, int N)
    {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[N];

        for (int index = 0; index < adj.size(); index++) {
            if (!visited[index]) {
                dfs(adj, index, visited, stack);
            }
        }

        List<Integer> trOrder = new ArrayList<>();
        while (!stack.isEmpty()) {
            trOrder.add(stack.pop());
        }

        ArrayList<ArrayList<Integer>> newAdj = new ArrayList<>();
        for (int index = 0; index < adj.size(); index++) {
            newAdj.add(new ArrayList<>());
        }
        for (int index = 0; index < adj.size(); index++) {
            if (adj.get(index).size() == 0) {
                continue;
            }
            ArrayList<Integer> list = adj.get(index);
            for (int vi = 0; vi < list.size(); vi++) {
                int val = list.get(vi);
                newAdj.get(val).add(index);
            }
        }

        int count = 0;
        visited = new boolean[N];
        for (int index = 0; index < trOrder.size(); index++) {
            if (!visited[trOrder.get(index)]) {
                dfs(newAdj, trOrder.get(index), visited, null);
                count++;
            }
        }

        return count;
    }

    private void dfs (ArrayList<ArrayList<Integer>> adj, int vertex, boolean[] visited, Stack<Integer> stack) {
        visited[vertex] = true;

        for (Integer v: adj.get(vertex)) {
            if (!visited[v]) {
                dfs(adj, v, visited, stack);
            }
        }
        if (stack != null) {
            stack.push(vertex);
        }
    }

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();

            int vertices = Integer.parseInt(sc.next());
            int edges = Integer.parseInt(sc.next());

            for (int i = 0; i < vertices; i++) {
                list.add(i, new ArrayList<>());
            }

            for (int i = 1; i <= edges; i++) {
                int u = Integer.parseInt(sc.next());
                int v = Integer.parseInt(sc.next());

                list.get(u).add(v);
            }

            Kosaraju k = new Kosaraju();
            int stronglyConnectedGraphs = k.kosaraju(list, vertices);
            System.out.println(stronglyConnectedGraphs);
        }
    }
}
