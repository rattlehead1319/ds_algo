package graph.medium;

import java.util.*;


public class RottenOranges {
    static class Helper {
        int row = 0;
        int col = 0;
        Helper (int row, int col) {
            this.row = row;
            this.col = col;

        }
    }
    public int rotOranges(int a[][],int r, int c)
    {
        Queue<Helper> queue = new LinkedList<>();
        int[][] dist = new int[r][c];
        boolean[][] visited = new boolean[r][c];

        for (int ri = 0; ri < r; ri++) {
            for (int ci = 0; ci < c; ci++) {
                if (a[ri][ci] == 2) {
                    queue.add(new Helper(ri, ci));
                    dist[ri][ci] = 0;
                    visited[ri][ci] = true;
                }
            }
        }

        int[] rowNghbr = new int[]{-1, 0, 0, 1};
        int[] colNghbr = new int[]{0, -1, 1, 0};

        while (!queue.isEmpty()) {
            Helper current = queue.poll();
            int row = current.row;
            int col = current.col;

            for (int k = 0; k < 4; k++) {
                int newRow = row + rowNghbr[k];
                int newCol = col + colNghbr[k];
                if (isSafe(a, newRow, newCol, visited)) {
                    visited[newRow][newCol] = true;
                    if (a[newRow][newCol] == 1) {
                        if (a[row][col] == 2) {
                            dist[newRow][newCol] = 1;
                        } else {
                            dist[newRow][newCol] = dist[row][col] + 1;
                        }
                        queue.add(new Helper(newRow, newCol));
                    }
                }
            }
        }

        int minTime = Integer.MIN_VALUE;
        for (int ri = 0; ri < r; ri++) {
            for (int ci = 0; ci < c; ci++) {
                if (a[ri][ci] == 1 && dist[ri][ci] == 0) {
                    return -1;
                }
                minTime = Math.max(minTime, dist[ri][ci]);
            }
        }
        return minTime;
    }

    private boolean isSafe (int[][] a, int row, int col, boolean[][] visited) {
        return row >= 0 && row < visited.length && col >= 0 &&
                col < visited[0].length && !visited[row][col];
    }
}
