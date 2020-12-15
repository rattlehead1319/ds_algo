package matrix.easy;

import java.util.*;

public class BoundaryTraversalOfMatrix {
    static ArrayList<Integer> boundaryTraversal(int matrix[][], int n, int m)
    {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            result.add(matrix[0][i]);
        }
        if (n == 1) {
            return result;
        }
        for (int i = 1; i < n; i++) {
            result.add(matrix[i][m-1]);
        }
        if (m == 1) {
            return result;
        }
        for (int i = m-2; i >= 0; i--) {
            result.add(matrix[n-1][i]);
        }
        for (int i = n-2; i >= 1; i--) {
            result.add(matrix[i][0]);
        }
        return result;
    }
}
