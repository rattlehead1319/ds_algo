package problems.medium.graph;

class Helper {
    int size;
}

public class MaxAreaOfIsland {
    int[] rows = new int[] {0, -1, 0, 1};
    int[] cols = new int[] {-1, 0, 1, 0};

    public int maxAreaOfIsland(int[][] grid) {

        if (grid == null || grid.length == 0) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int res = Integer.MIN_VALUE;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    Helper h = new Helper();
                    dfs(grid, i, j, visited, h);
                    res = Math.max(res, h.size);
                }
            }
        }

        return res == Integer.MIN_VALUE ? 0 : res;
    }

    private void dfs(int[][] grid, int row, int col, boolean[][] visited, Helper h) {
        visited[row][col] = true;
        h.size++;


        for (int i = 0; i < 4; i++) {

            int newRow = row + rows[i];
            int newCol = col + cols[i];

            if (newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length &&
                    !visited[newRow][newCol] && grid[newRow][newCol] == 1)
            {
                dfs(grid, newRow, newCol, visited, h);
            }
        }
    }
}
