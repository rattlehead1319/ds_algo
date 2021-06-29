package problems.medium.graph;

import java.util.*;

public class TheMaze {
    private int[] rows = new int[]{0, -1, 0, 1};
    private int[] cols = new int[]{-1, 0, 1, 0};

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        Queue<int[]> queue = new LinkedList<>();
        int m = maze.length;
        int n = maze[0].length;
        boolean[][] visited = new boolean[m][n];
        queue.add(start);
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int currX = curr[0];
            int currY = curr[1];
            if (currX == destination[0] && currY == destination[1]) {
                return true;
            }
            for (int i = 0; i < 4; i++) {
                int nextX = currX + rows[i];
                int nextY = currY + cols[i];
                while (nextX >= 0 && nextY >= 0 && nextX < m && nextY < n &&
                        maze[nextX][nextY] == 0)
                {
                    nextX = nextX + rows[i];
                    nextY = nextY + cols[i];
                }
                nextX = nextX - rows[i];
                nextY = nextY - cols[i];
                if (!visited[nextX][nextY]) {
                    queue.add(new int[]{nextX, nextY});
                    visited[nextX][nextY] = true;
                }
            }
        }
        return false;
    }
}
