package arrays.and.strings;

/**
 * Must visit again
 */

public class RotateMatrix {
    void rotate90degree (int[][] matrix, int n) {
        for (int layer = 0; layer < n/2; layer++) {
            int first = layer;
            int last = n - layer - 1;
            for (int index = 0; index < last; index++) {
                int offset = index - first;
                /*******
                 *  2 3 4 5
                 *  1 3 4 6
                 *  3 4 6 1
                 *  2 8 4 5
                 *
                 *  top -> matrix[first][index]
                 *  right -> matrix[index][last]
                 *  bottom -> matrix[last][last - offset]
                 *  left -> matrix[last - offset][first]
                 *******/

                //save top
                int top = matrix[first][index];
                //top gets from left
                matrix[first][index] = matrix[last - offset][first];
                //left gets from bottom
                matrix[last - offset][first] = matrix[last][last - offset];
                //bottom gets from right
                matrix[last][last - offset] = matrix[index][last];
                //right gets from top
                matrix[index][last] = top;
            }
        }
    }
}
