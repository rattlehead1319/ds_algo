package matrix.basic;

import java.util.*;

public class PrintMatrixInSnakePattern {
    static ArrayList<Integer> snakePattern(int matrix[][])
    {
        ArrayList<Integer> result = new ArrayList<>();
        int i = 0;
        while (i < matrix.length) {
            if (i%2 == 0) {
                for (int j = 0; j < matrix[0].length; j++) {
                    result.add(matrix[i][j]);
                }
            } else {
                for (int j = matrix[0].length - 1; j >= 0; j--) {
                    result.add(matrix[i][j]);
                }
            }
            i++;
        }
        return result;
    }
}
