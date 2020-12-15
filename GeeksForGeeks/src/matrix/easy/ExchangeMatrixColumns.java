package matrix.easy;

public class ExchangeMatrixColumns {
    static void exchangeColumns(int matrix[][])
    {
        for (int i = 0; i < matrix.length; i++) {
            swap(matrix, i);
        }
    }

    static void swap(int[][] matrix, int i) {
        int m = matrix[i].length;
        int temp = matrix[i][0];
        matrix[i][0] = matrix[i][m-1];
        matrix[i][m-1] = temp;
    }
}
