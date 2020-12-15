package matrix.basic;

public class RotateBy90 {
    static void rotateby90(int matrix[][], int n)
    {
        transpose(matrix, n);
        reverseRows(matrix, n);
    }

    static void transpose (int[][] matrix, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i < j) {
                    swap(matrix, i, j);
                }
            }
        }
    }

    static void swap (int[][] matrix, int i, int j) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
    }

    static void reverseRows (int[][] matrix, int n) {
        int up = n/2 - 1;
        int down = n%2 == 0 ? n/2 : n/2 + 1;

        while (up >= 0 && down < n) {
            for (int i = 0; i < n; i++) {
                swap(matrix, up, i, down, i);
            }
            up--;
            down++;
        }
    }

    static void swap (int[][] matrix, int i, int j, int p, int q) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[p][q];
        matrix[p][q] = temp;
    }
}
