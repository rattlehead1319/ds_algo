package graph.medium;

import java.util.*;

public class MinSwapsToSort {
    static class Helper implements Comparable<Helper> {
        int value;
        int index;
        Helper (int value, int index) {
            this.value = value;
            this.index = index;
        }
        @Override
        public int compareTo (Helper h) {
            return this.value - h.value;
        }
    }

    public int minSwaps(int[] arr, int N) {

        ArrayList<Helper> sortedList = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            sortedList.add(new Helper(arr[i], i));
        }
        Collections.sort(sortedList);

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            if (arr[i] != sortedList.get(i).value) {
                list.add(sortedList.get(i).index);
            }
            graph.add(i, list);
        }

        return graphCycle(graph, N);
    }

    private int graphCycle (ArrayList<ArrayList<Integer>> graph, int N) {
        boolean[] visited = new boolean[N];
        int swaps = 0;
        for (int index = 0; index < graph.size(); index++) {
            if (!visited[index]) {
                boolean[] recStckArr = new boolean[N];
                boolean hasCycle = dfs(graph, index, visited, recStckArr);
                if (hasCycle) {
                    int nodes = 0;
                    for (int j = 0; j < recStckArr.length; j++) {
                        if (recStckArr[j]) {
                            nodes++;
                        }
                    }
                    swaps += nodes - 1;
                }
            }
        }
        return swaps;
    }

    private boolean dfs (ArrayList<ArrayList<Integer>> graph, int vertex, boolean[] visited, boolean[] recStckArr) {
        visited[vertex] = true;
        recStckArr[vertex] = true;
        for (Integer v: graph.get(vertex)) {
            if (!visited[v]) {
                if (dfs(graph, v, visited, recStckArr)) {
                    return true;
                }
            } else if (recStckArr[v]) {
                return true;
            }
        }
        recStckArr[vertex] = false;
        return false;
    }

    public static void main (String[] args) {
        MinSwapsToSort msts = new MinSwapsToSort();
        System.out.println(msts.minSwaps(new int[]{4, 3, 2, 1}, 4));
    }
}
