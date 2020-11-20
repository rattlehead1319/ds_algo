package graph.medium;

import java.util.*;

/**
 * Must visit again. Trick is to do BFS and have all 1's pushed into queue first
 */

public class DistanceOfNearestCellHaving1 {
    static class Helper {
        int row = 0;
        int col = 0;
        Helper (int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    static ArrayList<ArrayList<Integer>> nearest(ArrayList<ArrayList<Integer>> mat, int N, int M) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Queue<Helper> queue = new LinkedList<>();
        int[][] dist = new int[N][M];
        boolean[][] visited = new boolean[N][M];

        for (int ri = 0; ri < N; ri++) {
            for (int ci = 0; ci < M; ci++) {
                if (mat.get(ri).get(ci) == 1) {
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

            int minDist = Integer.MAX_VALUE;
            for (int k = 0; k < 4; k++) {
                int newRow = row + rowNghbr[k];
                int newCol = col + colNghbr[k];
                if (isSafe(mat, N, M, newRow, newCol, visited)) {
                    visited[newRow][newCol] = true;
                    if (mat.get(row).get(col) == 1) {
                        dist[newRow][newCol] = 1;
                    } else {
                        dist[newRow][newCol] = dist[row][col] + 1;
                    }
                    queue.add(new Helper(newRow, newCol));
                }
            }
        }

        for (int ri = 0; ri < N; ri++) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int ci = 0; ci < M; ci++) {
                list.add(dist[ri][ci]);
            }
            result.add(list);
        }
        return result;
    }


    static boolean isSafe (ArrayList<ArrayList<Integer>> mat, int N, int M, int row, int col, boolean[][] visited) {
        return row >= 0 && row < N && col >= 0 && col < M &&
                !visited[row][col] && mat.get(row).get(col) == 0;
    }
}
