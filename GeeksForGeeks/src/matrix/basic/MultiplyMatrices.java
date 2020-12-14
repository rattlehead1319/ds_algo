package matrix.basic;

public class MultiplyMatrices {
    static int[][] multiplyMatrix(int A[][], int B[][])
    {
        int[][] result = new int[A.length][B[0].length];
        if (A[0].length != B.length) {
            return new int[][]{};
        }

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B[0].length; j++) {
                int x = 0;
                for (int k = 0; k < B.length; k++) {
                    x += A[i][k] * B[k][j];
                }
                result[i][j] = x;
            }
        }

        return result;
    }
}
