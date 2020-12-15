package matrix.easy;

public class ReversingColumnsOfMatrix {
    static void reverseCol(int matrix[][])
    {
        int n = matrix.length;
        int m = matrix[0].length;
        int left = m/2-1;
        int right = m%2 == 0 ? m/2 : m/2+1;

        while (left >= 0 && right < m) {
            for (int i = 0; i < n; i++) {
                swap(matrix, i, left, i, right);
            }
            left--;
            right++;
        }
    }

    static void swap (int[][] matrix, int i, int j, int p , int q) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[p][q];
        matrix[p][q] = temp;
    }
}
