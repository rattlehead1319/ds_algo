package matrix.basic;

import java.util.*;

public class SumOfUpperAndLowerTriangles {
    static ArrayList<Integer> sumTriangles(int matrix[][], int n)
    {
        int sumUpper = 0;
        int sumLower = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j >= i) {
                    sumUpper += matrix[i][j];
                }
                if (i >= j) {
                    sumLower += matrix[i][j];
                }
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        result.add(sumUpper);
        result.add(sumLower);

        return result;
    }
}
