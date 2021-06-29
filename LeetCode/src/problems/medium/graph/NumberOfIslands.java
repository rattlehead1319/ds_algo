package problems.medium.graph;

//There exists a better solution.. disjoint sets.. visit LC

public class NumberOfIslands {
    private int[] rows = new int[]{0, -1, 0, 1};
    private int[] cols = new int[]{-1, 0, 1, 0};

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    dfs(grid, i, j, visited);
                    result++;
                }
            }
        }
        return result;
    }

    private void dfs(char[][] grid, int row, int col, boolean[][] visited) {
        visited[row][col] = true;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int nextRow = row + rows[i];
                int nextCol = col + cols[i];
                if (nextRow >= 0 && nextRow < grid.length && nextCol >= 0 && nextCol < grid[0].length &&
                        grid[nextRow][nextCol] == '1' && !visited[nextRow][nextCol])
                {
                    dfs(grid, nextRow, nextCol, visited);
                }
            }
        }
    }
}
