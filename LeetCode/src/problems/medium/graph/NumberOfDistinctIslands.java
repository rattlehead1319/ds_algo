package problems.medium.graph;

import java.util.*;

public class NumberOfDistinctIslands {
    private int[] rows = new int[]{0, -1, 0, 1};
    private int[] cols = new int[]{-1, 0, 1, 0};
    String pattern = "";
    Set<String> patterns = new HashSet<>();

    public int numDistinctIslands(int[][] grid) {
        int count = 0;
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(!visited[i][j] && grid[i][j] == 1) {
                    pattern = "0";
                    dfs(grid, i, j, visited);
                    patterns.add(pattern);
                }
            }
        }
        return patterns.size();
    }

    private void dfs(int[][] grid, int row, int col, boolean[][] visited) {
        visited[row][col] = true;
        for (int i = 0; i < 4; i++) {
            int nextRow = row + rows[i];
            int nextCol = col + cols[i];
            if (nextRow >= 0 && nextRow < grid.length && nextCol >= 0 &&
                    nextCol < grid[0].length && !visited[nextRow][nextCol] &&
                    grid[nextRow][nextCol] == 1)
            {
                pattern += getPattern(i);
                dfs(grid, nextRow, nextCol, visited);
                pattern += "0";
            }
        }
    }

    private String getPattern(int i) {
        switch(i) {
            case 0:
                return "L";
            case 1:
                return "U";
            case 2:
                return "R";
            case 3:
                return "D";
        }
        return "invalid";
    }
}
