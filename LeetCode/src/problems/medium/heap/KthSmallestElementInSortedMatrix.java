package problems.medium.heap;

import java.util.*;

public class KthSmallestElementInSortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Helper> pq = new PriorityQueue<>((a, b) -> a.value - b.value);
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            pq.add(new Helper(matrix[i][0], i, 0));
        }
        k--;
        while (k > 0) {
            while (k > 0 && pq.peek().col == n - 1) {
                pq.poll();
                k--;
            }
            if (k == 0) {
                break;
            }
            Helper curr = pq.poll();
            int row = curr.row;
            int col = curr.col + 1;
            pq.add(new Helper(matrix[row][col], row, col));
            k--;
        }
        return pq.peek().value;
    }

    class Helper {
        int value;
        int row;
        int col;
        Helper (int value, int row, int col) {
            this.value = value;
            this.row = row;
            this.col = col;
        }
    }
}
