package graph.medium;

import java.util.*;

/**
 * Must visit again
 */

public class FindIslands {
    // Function to find the number of island in the given list A
    // N, M: size of list row and column respectively
    static int findIslands(ArrayList<ArrayList<Integer>> A, int N, int M) {

        int count = 0;
        boolean[][] visited = new boolean[N][M];
        for (int ri = 0; ri < N; ri++) {
            for (int ci = 0; ci < M; ci++) {
                if (A.get(ri).get(ci) == 1 && !visited[ri][ci]) {
                    findIslandsRec(A, ri, ci, visited);
                    count++;
                }
            }
        }
        return count;
    }

    static void findIslandsRec (ArrayList<ArrayList<Integer>> A, int row, int col, boolean[][] visited) {
        //Hint: draw neighbour indices around a central element in matrix
        int[] rowNeighbor = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};
        int[] colNeighbor = new int[]{-1, 0, 1, -1, 1, -1, 0, 1};

        visited[row][col] = true;

        for (int i = 0; i < 8; i++) {
            if (isSafe(A, row + rowNeighbor[i], col + colNeighbor[i], visited)) {
                findIslandsRec(A, row + rowNeighbor[i], col + colNeighbor[i], visited);
            }
        }
    }

    static boolean isSafe (ArrayList<ArrayList<Integer>> A, int row, int col, boolean[][] visited) {
        return row >= 0 && row < A.size() && col >= 0 &&
                col < A.get(0).size() && A.get(row).get(col) == 1 && !visited[row][col];
    }

}
