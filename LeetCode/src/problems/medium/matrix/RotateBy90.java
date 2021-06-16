package problems.medium.matrix;

public class RotateBy90 {
    public void rotate(int[][] matrix) {

        int m = matrix.length;
        int j = 0;

        while (j < m) {
            int top = 0;
            int bottom = m-1;
            while (top < bottom) {
                swap(matrix, top, j, bottom, j);
                top++;
                bottom--;
            }
            j++;
        }

        int i = 0;
        while (i < m) {
            int left = i + 1;
            int bottom = i + 1;
            while (left < m && bottom < m) {
                swap(matrix, i, left, bottom, i);
                left++;
                bottom++;
            }
            i++;
        }
    }

    private void swap(int[][] matrix, int i, int j, int m, int n) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[m][n];
        matrix[m][n] = temp;
    }
}
