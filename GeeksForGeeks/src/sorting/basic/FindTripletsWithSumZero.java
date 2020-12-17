package sorting.basic;

import java.util.*;

public class FindTripletsWithSumZero {
    public boolean findTriplets(int arr[] , int n)
    {
        Arrays.sort(arr);
        if (arr[0] >= 0) {
            return false;
        }

        for (int i = 0; i < n-2; i++) {
            int j = i+1;
            int k = n-1;

            int x = 0 - arr[i];
            while (j < k) {
                if (arr[j] + arr[k] == x) {
                    return true;
                } else if (arr[j] + arr[k] < x) {
                    j++;
                } else {
                    k--;
                }
            }
        }

        return false;
    }
}
