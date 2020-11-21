package graph.medium;

import java.util.*;

public class UnitAreaOfLargestRegionOf1s {
    static class Helper {
        int count = 0;
    }

    static int findMaxArea(int N, int M, int A[][]) {
        boolean[][] visited = new boolean[N][M];
        int largestRegion = Integer.MIN_VALUE;

        for (int ri = 0; ri < N; ri++) {
            for (int ci = 0; ci < M; ci++) {
                if (!visited[ri][ci] && A[ri][ci] == 1) {
                    Helper h = new Helper();
                    dfs(A, ri, ci, visited, h);
                    largestRegion = Math.max(largestRegion, h.count);
                }
            }
        }
        return largestRegion;
    }

    static void dfs (int[][] mat, int row, int col, boolean[][] visited, Helper h) {
        visited[row][col] = true;
        h.count++;

        int[] rowNghbr = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};
        int[] colNghbr = new int[]{-1, 0, 1, -1, 1, -1, 0, 1};

        for (int k = 0; k < 8; k++) {
            if (isSafe(mat, row + rowNghbr[k], col + colNghbr[k], visited)) {
                dfs(mat, row + rowNghbr[k], col + colNghbr[k], visited, h);
            }
        }
    }

    static boolean isSafe (int[][] mat, int row, int col, boolean[][] visited) {
        return row >= 0 && row < visited.length && col >= 0 && col < visited[0].length &&
                !visited[row][col] && mat[row][col] == 1;
    }
}
