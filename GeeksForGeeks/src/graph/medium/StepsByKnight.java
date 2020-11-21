package graph.medium;

import java.util.*;

public class StepsByKnight {
    static class Helper {
        int x;
        int y;
        Helper (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int minStepToReachTarget(int knightpos[], int targetpos[], int N) {
        boolean[][] visited = new boolean[N+1][N+1];
        int[][] dist = new int[N+1][N+1];

        Queue<Helper> queue = new LinkedList<>();
        queue.add(new Helper(knightpos[0], knightpos[1]));
        visited[knightpos[0]][knightpos[1]] = true;

        int[] rowNghbr = new int[]{-2, -1, 1, 2, 2, 1, -1, -2};
        int[] colNghbr = new int[]{1, 2, 2, 1, -1, -2, -2, -1};

        int minDist = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            Helper current = queue.poll();
            int currX = current.x;
            int currY = current.y;

            if (currX == targetpos[0] && currY == targetpos[1]) {
                minDist = Math.min(minDist, dist[currX][currY]);
            }

            for (int k = 0; k < 8; k++) {
                int nextX = currX + rowNghbr[k];
                int nextY = currY + colNghbr[k];
                if (isSafe(nextX, nextY, visited)) {
                    visited[nextX][nextY] = true;
                    dist[nextX][nextY] = dist[currX][currY] + 1;
                    queue.add(new Helper(nextX, nextY));
                }
            }
        }
        if (minDist == Integer.MAX_VALUE) {
            return 0;
        }
        return minDist;
    }

    private boolean isSafe(int row, int col, boolean[][] visited) {
        return row >= 1 && row < visited.length && col >= 1 && col < visited.length &&
                !visited[row][col];
    }

    public static void main (String[] args) {
        StepsByKnight sbk = new StepsByKnight();
        int steps = sbk.minStepToReachTarget(new int[]{4, 5}, new int[]{1, 1},6);
        System.out.println(steps);
    }
}
