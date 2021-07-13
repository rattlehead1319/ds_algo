package problems.medium.graph;

import java.util.*;

public class ShortestPathInBinaryMatrix {
    private int[] rows = new int[]{0, -1, -1, -1, 0, 1, 1, 1};
    private int[] cols = new int[]{-1, -1, 0, 1, 1, 1, 0, -1};

    public int shortestPathBinaryMatrix(int[][] grid) {

        if (grid[0][0] == 1) {
            return -1;
        }

        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0});

        int[][] dist = new int[m][n];
        for (int[] x : dist) {
            Arrays.fill(x, Integer.MAX_VALUE);
        }
        dist[0][0] = 1;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentX = current[0];
            int currentY = current[1];

            for (int i = 0; i < 8; i++) {
                int nextX = currentX + rows[i];
                int nextY = currentY + cols[i];

                if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n &&
                        grid[nextX][nextY] == 0 && (dist[currentX][currentY] + 1) < dist[nextX][nextY])
                {
                    dist[nextX][nextY] = dist[currentX][currentY] + 1;
                    queue.add(new int[]{nextX, nextY});
                }
            }
        }

        return dist[m-1][n-1] == Integer.MAX_VALUE ? -1 : dist[m-1][n-1];
    }
}
