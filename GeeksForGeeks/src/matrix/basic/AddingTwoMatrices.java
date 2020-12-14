package matrix.basic;

public class AddingTwoMatrices {
    static int[][] sumMatrix(int A[][], int B[][])
    {
        if (A.length != B.length || A[0].length != B[0].length) {
            return new int[][]{};
        }

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                A[i][j] = A[i][j] + B[i][j];
            }
        }
        return A;
    }
}
