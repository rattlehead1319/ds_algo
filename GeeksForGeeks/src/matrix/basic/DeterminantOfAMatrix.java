package matrix.basic;

public class DeterminantOfAMatrix {
    static int determinantOfMatrix(int matrix[][], int n)
    {
        if (n == 1) {
            return matrix[0][0];
        }
        if (n == 2) {
            //System.out.println(matrix[0][0]*matrix[1][1] - matrix[0][1]*matrix[1][0]);
            return matrix[0][0]*matrix[1][1] - matrix[0][1]*matrix[1][0];
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (matrix[0][i] == 0) {
                continue;
            }
            if (i%2 == 0) {
                result += matrix[0][i] * determinantOfMatrix(getMatrix(matrix, i, n), n-1);
            } else {
                result -= matrix[0][i] * determinantOfMatrix(getMatrix(matrix, i, n), n-1);
            }
        }
        return result;
    }

    static int[][] getMatrix(int[][] matrix, int x, int n) {
        int[][] sub = new int[n-1][n-1];

        int p = 0;
        for (int i = 1; i < n; i++) {
            int q = 0;
            for (int j = 0; j < n; j++) {
                if (j != x) {
                    sub[p][q++] = matrix[i][j];
                }
            }
            p++;
        }
        return sub;
    }

    public static void main (String[] args) {
        int matrix[][] = {{1, 0, 2, -1},
                {3, 0, 0, 5},
                {2, 1, 4, -3},
                {1, 0, 5, 0}};
        int x = determinantOfMatrix(matrix, 4);
        System.out.println(x);
    }
}
