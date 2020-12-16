package matrix.medium;

public class BooleanMatrix {
    void booleanMatrix(int matrix[][])
    {
        boolean firstRowHasOne = false;
        boolean firstColumnHasOne = false;

        int[][] aux = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[0][0] == 1) {
                firstRowHasOne = true;
                firstColumnHasOne = true;
            }
            if (matrix[i][0] == 1) {
                firstColumnHasOne = true;
                aux[i][0] = 1;
                matrix[i][0] = 0;
            }
        }

        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == 1) {
                firstRowHasOne = true;
                aux[0][i] = 1;
                matrix[0][i] = 1;
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1) {
                    aux[0][j] = 1;
                    aux[i][0] = 1;
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            if (aux[i][0] == 1) {
                for (int j = 0; j < matrix[0].length; j++) {
                    matrix[i][j] = 1;
                }
            }
        }

        for (int j = 0; j < matrix[0].length; j++) {
            if (aux[0][j] == 1) {
                for (int i = 0; i < matrix.length; i++) {
                    matrix[i][j] = 1;
                }
            }
        }

        if (firstRowHasOne) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[0][j] = 1;
            }
        }

        if (firstColumnHasOne) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 1;
            }
        }
    }
}
