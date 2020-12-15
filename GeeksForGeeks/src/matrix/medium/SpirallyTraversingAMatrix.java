package matrix.medium;

import java.util.*;

public class SpirallyTraversingAMatrix {
    static ArrayList<Integer> spirallyTraverse(int matrix[][], int r, int c)
    {
        ArrayList<Integer> list = new ArrayList<>();
        if (r == 1) {
            for (int i = 0; i < c; i++) {
                list.add(matrix[0][i]);
            }
            return list;
        }
        if (c == 1) {
            for (int i = 0; i < r; i++) {
                list.add(matrix[i][0]);
            }
            return list;
        }

        int top = 0;
        int bottom = r-1;
        int left = 0;
        int right = c-1;

        while (left <= right && top < r && bottom >= 0 && top <= bottom) {
            for (int i = left; i <= right; i++) {
                list.add(matrix[top][i]);
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                list.add(matrix[i][right]);
            }
            right--;
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    list.add(matrix[bottom][i]);
                }
            }
            bottom--;
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    list.add(matrix[i][left]);
                }
            }
            left++;
        }

        return list;
    }
}
