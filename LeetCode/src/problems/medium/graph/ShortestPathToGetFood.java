package problems.medium.graph;

import java.util.*;

public class ShortestPathToGetFood {
    private int[] rows = new int[]{0, -1, 0, 1};
    private int[] cols = new int[]{-1, 0, 1, 0};

    public int getFood(char[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '*') {
                    queue.add(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        int dist = 0;
        while (!queue.isEmpty()) {
            int count = queue.size();
            while (count-- > 0) {
                int[] neighbor = queue.poll();
                int currRow = neighbor[0];
                int currCol = neighbor[1];
                if (grid[currRow][currCol] == '#') {
                    return dist;
                }

                for (int i = 0; i < 4; i++) {
                    int nextRow = currRow + rows[i];
                    int nextCol = currCol + cols[i];

                    if (nextRow >= 0 && nextRow < m && nextCol >= 0 && nextCol < n &&
                            !visited[nextRow][nextCol] && grid[nextRow][nextCol] != 'X')
                    {
                        visited[nextRow][nextCol] = true;
                        queue.add(new int[]{nextRow, nextCol});
                    }
                }
            }
            dist++;
        }

        return -1;
    }
}
