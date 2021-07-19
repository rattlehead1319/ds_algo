package problems.medium.matrix;

import java.util.*;

public class SortMatrixDiagonally {
    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int i = 0;
        int j = n-1;

        while (j >= 0) {
            sort(mat, i, j, m, n);
            j--;
        }

        j = 0;
        while (i < m) {
            sort(mat, i, j, m, n);
            i++;
        }

        return mat;
    }

    private void sort(int[][] mat, int i, int j, int m, int n) {
        List<int[]> indices = new LinkedList<>();
        List<Integer> values = new ArrayList<>();
        int row = i;
        int col = j;
        while (row < m && col < n) {
            indices.add(new int[]{row, col});
            values.add(mat[row][col]);
            col++;
            row++;
        }
        Collections.sort(values);
        for (int index = 0; index < values.size(); index++) {
            int[] cell = indices.get(index);
            mat[cell[0]][cell[1]] = values.get(index);
        }
    }
}
