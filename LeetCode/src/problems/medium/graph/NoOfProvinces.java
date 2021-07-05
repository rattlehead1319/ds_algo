package problems.medium.graph;

public class NoOfProvinces {
    public int findCircleNum(int[][] isConnected) {
        return mySolution(isConnected);
        //return lcSolution(isConnected);
    }

    private int mySolution(int[][] isConnected) {
        int noOfProvinces = 0;
        int m = isConnected.length;
        int n = isConnected[0].length;
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && isConnected[i][j] == 1) {
                    dfs(isConnected, i, j, visited);
                    noOfProvinces++;
                }
            }
        }

        return noOfProvinces;
    }

    private void dfs(int[][] graph, int row, int col, boolean[][] visited) {
        visited[row][col] = true;

        for (int j = 0; j < graph[0].length; j++) {
            if (!visited[row][j] && graph[row][j] == 1) {
                dfs(graph, row, j, visited);
            }
        }

        for (int i = 0; i < graph.length; i++) {
            if (!visited[i][col] && graph[i][col] == 1) {
                dfs(graph, i, col, visited);
            }
        }
    }

    private int lcSolution(int[][] M) {
        int[] visited = new int[M.length];
        int count = 0;
        for (int i = 0; i < M.length; i++) {
            if (visited[i] == 0) {
                lcdfs(M, visited, i);
                count++;
            }
        }
        return count;
    }

    private void lcdfs(int[][] M, int[] visited, int i) {
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                lcdfs(M, visited, j);
            }
        }
    }
}
