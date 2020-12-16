package matrix.easy;

public class ReversingRows {
    static void interchangeRows(int matrix[][])
    {
        int n = matrix.length;
        int m = matrix[0].length;

        int top = n/2 -1;
        int bottom = n%2 == 0 ? n/2 : n/2 + 1;

        while (top >= 0 && bottom < n) {
            for (int i = 0; i < m; i++) {
                swap(matrix, top, i, bottom, i);
            }
            top--;
            bottom++;
        }
    }

    static void swap (int[][] m, int i, int j, int p, int q) {
        int temp = m[i][j];
        m[i][j] = m[p][q];
        m[p][q] = temp;
    }
}
