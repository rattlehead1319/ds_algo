package graph.hard;

import java.util.*;

public class MinCostPath {
    static class Helper {
        int row;
        int col;
        int value;
        Helper (int row, int col, int value) {
            this.row = row;
            this.col = col;
            this.value = value;
        }
    }

    private static int shortest(int grid[][],int n)
    {
        PriorityQueue<Helper> pq = new PriorityQueue<>((a, b) -> a.value - b.value);
        int[][] dist = new int[n][n];
        boolean[][] visited = new boolean[n][n];

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                dist[row][col] = Integer.MAX_VALUE;
            }
        }

        pq.add(new Helper(0, 0, grid[0][0]));
        visited[0][0] = true;
        dist[0][0] = grid[0][0];

        int[] rowNghbr = new int[]{-1, 0, 0, 1};
        int[] colNghbr = new int[]{0, -1, 1, 0};

        while (!pq.isEmpty()) {
            Helper h = pq.poll();
            int currentRow = h.row;
            int currentCol = h.col;


            for (int k = 0; k < 4; k++) {
                int nextRow = currentRow + rowNghbr[k];
                int nextCol = currentCol + colNghbr[k];

                if (isSafe(grid, nextRow, nextCol, visited)) {
                    visited[nextRow][nextCol] = true;

                    if (dist[currentRow][currentCol] + grid[nextRow][nextCol] < dist[nextRow][nextCol]) {
                        dist[nextRow][nextCol] = dist[currentRow][currentCol] + grid[nextRow][nextCol];
                        pq.add(new Helper(nextRow, nextCol, dist[nextRow][nextCol]));
                    }
                }
            }
        }

        return dist[n-1][n-1];
    }

    private static boolean isSafe(int[][] grid, int row, int col, boolean[][] visited) {
        return row >= 0 && row < visited.length && col >= 0 && col < visited.length && !visited[row][col];
    }
}
