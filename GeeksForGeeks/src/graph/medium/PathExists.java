package graph.medium;

import java.util.*;

public class PathExists {

    public static int is_possible(int M[][], int N) {
        boolean[][] visited = new boolean[N][N];
        for (int ri = 0; ri < M.length; ri++) {
            for (int ci = 0; ci < M.length; ci++) {
                if (!visited[ri][ci] && M[ri][ci] == 1) {
                    if (dfs(M, ri, ci, visited)) {
                        return 1;
                    }
                }
            }
        }
        return 0;
    }

    private static boolean dfs(int[][] M, int row, int col, boolean[][] visited) {
        if (M[row][col] == 2) {
            return true;
        }

        visited[row][col] = true;
        int[] dir_x = new int[]{-1, 0, 0, 1};
        int[] dir_y = new int[]{0, -1, 1, 0};

        for (int k = 0; k < 4; k++) {
            if (isSafe(M, row + dir_x[k], col + dir_y[k], visited)) {
                if (dfs(M, row + dir_x[k], col + dir_y[k], visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isSafe(int[][] M, int row, int col, boolean[][] visited) {
        return row >= 0 && row < M.length && col >= 0 && col < M.length &&
                !visited[row][col] && (M[row][col] == 3 || M[row][col] == 2);
    }
}
