package problems.medium.heap;

import java.util.*;

public class KClosestPointsToOrigin {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> Double.compare(Math.sqrt(b[0]*b[0] + b[1]*b[1]), Math.sqrt(a[0]*a[0] + a[1]*a[1]))
        );

        for (int i = 0; i < k; i++) {
            pq.add(points[i]);
        }

        for (int i = k; i < points.length; i++) {
            int[] point1 = points[i];
            int[] point2 = pq.peek();
            if (Double.compare(Math.sqrt(point1[0]*point1[0] + point1[1]*point1[1]),
                    Math.sqrt(point2[0]*point2[0] + point2[1]*point2[1])) < 0)
            {
                pq.poll();
                pq.add(point1);
            }
        }

        int[][] result = new int[pq.size()][2];
        int resultIndex = 0;
        while (!pq.isEmpty()){
            result[resultIndex++] = pq.poll();
        }

        return result;
    }
}
