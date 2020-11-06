package arrays.and.strings;

/**
 * this one is good too
 * mark first row and column if they have 0, so that they can be turned 0 at last
 * traverse the matrix and mark their row's and column's first element as 0 when you find 0
 * then traverse again and mark row and column 0 where you find first element 0
 * lastly, based on initial flag, make first row and column 0
 */

public class ZeroMatrix {
    void makeZero(int[][] matrix) {
        boolean firstRowHasZero = false;
        boolean firstColumnHasZero = false;

        for (int index = 0; index < matrix.length; index++) {
            if (matrix[index][0] == 0) {
                firstColumnHasZero = true;
                break;
            }
        }

        for (int index = 0; index < matrix[0].length; index++) {
            if (matrix[0][index] == 0) {
                firstRowHasZero = true;
                break;
            }
        }

        for (int rowIndex = 1; rowIndex < matrix.length; rowIndex++) {
            for (int colIndex = 1; colIndex < matrix[0].length; colIndex++) {
                if (matrix[rowIndex][colIndex] == 0) {
                    matrix[rowIndex][0] = 0;
                    matrix[0][colIndex] = 0;
                }
            }
        }

        for (int index = 0; index < matrix[0].length; index++) {
            if (matrix[0][index] == 0) {
                nullifyColumn(matrix, index);
            }
        }

        for (int index = 0; index < matrix.length; index++) {
            if (matrix[index][0] == 0) {
                nullifyRow(matrix, index);
            }
        }

        if (firstRowHasZero) {
            nullifyRow(matrix, 0);
        }
        if (firstColumnHasZero) {
            nullifyColumn(matrix, 0);
        }
    }

    void nullifyColumn(int[][] matrix, int colIndex) {
        for (int index = 0; index < matrix.length; index++) {
            matrix[index][colIndex] = 0;
        }
    }

    void nullifyRow(int[][] matrix, int rowIndex) {
        for (int index = 0; index < matrix[0].length; index++) {
            matrix[rowIndex][index] = 0;
        }
    }
}
