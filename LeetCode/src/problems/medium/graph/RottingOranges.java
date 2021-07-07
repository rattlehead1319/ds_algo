package problems.medium.graph;

import java.util.*;

public class RottingOranges {
    private int[] rows = new int[]{0, -1, 0, 1};
    private int[] cols = new int[]{-1, 0, 1, 0};

    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;

        int freshOranges = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    freshOranges++;
                }
            }
        }

        if (freshOranges == 0) {
            return 0;
        }

        boolean[][] visited = new boolean[m][n];
        int orangesRottenByInfluence = 0;
        int minutes = 0;

        while (!queue.isEmpty()) {
            List<int[]> rottenOranges = new ArrayList<>();
            int queueSize = queue.size();
            for (int k = 0; k < queueSize; k++) {
                rottenOranges.add(queue.poll());
            }
            for (int k = 0; k < rottenOranges.size(); k++) {
                int[] rottenOrange = rottenOranges.get(k);
                visited[rottenOrange[0]][rottenOrange[1]] = true;

                for (int i = 0; i < 4; i++) {
                    int nextRow = rottenOrange[0] + rows[i];
                    int nextCol = rottenOrange[1] + cols[i];

                    if (nextRow >= 0 && nextRow < m && nextCol >= 0 && nextCol < n &&
                            !visited[nextRow][nextCol] && grid[nextRow][nextCol] == 1)
                    {
                        queue.add(new int[]{nextRow, nextCol});
                        grid[nextRow][nextCol] = 2;
                        orangesRottenByInfluence++;
                    }
                }
            }
            minutes++;
            if (orangesRottenByInfluence == freshOranges) {
                return minutes;
            }
        }

        return -1;
    }
}
