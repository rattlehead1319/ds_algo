package hashing.basic;

import java.util.*;

public class IntersectionOfTwoArrays {
    public static int NumberofElementsInIntersection (int a[], int b[] , int n, int m)
    {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(a[i], 1);
        }
        int count = 0;
        for (int i = 0; i < m; i++) {
            if (map.get(b[i]) != null && map.get(b[i]) != -1) {
                count++;
                map.put(b[i], -1);
            }
        }
        return count;
    }
}
