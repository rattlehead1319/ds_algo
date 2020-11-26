package backtrack.medium;

import java.util.*;

public class RatMazeWithMultipleJumps {
    public static void solve(int[][] maze, int N) {
        if (maze[0][0] == 0) {
            System.out.println(-1);
            return;
        }

        int[][] result = new int[N][N];
        result[0][0] = 1;

        boolean possible = move(maze, 0, 0, N, result);
        if (!possible) {
            System.out.println(-1);
            return;
        } else {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(result[i][j] + " ");
                }
                System.out.println();
            }
        }
    }

    private static boolean move (int[][] maze, int row, int col, int N, int[][] result) {
        if (row == N-1 && col == N-1) {
            result[row][col] = 1;
            return true;
        }
        if (isSafe(maze, row, col)) {
            result[row][col] = 1;

            int jumps = maze[row][col];
            while (jumps > 0) {
                if (move(maze, row + jumps, col, N, result)) {
                    return true;
                } else if (move(maze, row, col + jumps, N, result)) {
                    return true;
                }
                jumps--;
            }

            //Backtrack
            result[row][col] = 0;
        }
        return false;
    }

    private static boolean isSafe (int[][] maze, int row, int col) {
        return row < maze.length && col < maze.length && maze[row][col] > 0;
    }
}
