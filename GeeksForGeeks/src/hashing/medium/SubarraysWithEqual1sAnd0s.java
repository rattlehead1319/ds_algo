package hashing.medium;

import java.util.*;

public class SubarraysWithEqual1sAnd0s {
    static int countSubarrWithEqualZeroAndOne(int arr[], int N)
    {
        for (int i = 0; i < N; i++) {
            if (arr[i] == 0) {
                arr[i] = -1;
            }
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        int preSum = 0;
        int result = 0;

        for (int i = 0; i < N; i++) {
            preSum += arr[i];

            if (preSum == 0) {
                result++;
            }
            Integer x = map.get(preSum);
            if (x == null) {
                map.put(preSum, 1);
            } else {
                result += x;
                map.put(preSum, x+1);
            }
        }

        return result;
    }
}
