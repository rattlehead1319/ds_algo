package arrays.easy;

import java.util.*;

public class ThreeSumClosest {
    static int threeSumClosest(int[] array, int target)
    {
        Arrays.sort(array);
        int minDiff = Integer.MAX_VALUE;
        int closestSum = 0;
        for (int i = 0; i < array.length; i++) {
            int sum = target - array[i];
            int j = i  + 1;
            int k = array.length - 1;
            while (j < k) {
                if (array[j] + array[k] == sum) {
                    return target;
                } else if (array[j] + array[k] > sum) {
                    int diff = array[j] + array[k] - sum;
                    if (diff <= minDiff) {
                        minDiff = diff;
                        closestSum = array[i] + array[j] + array[k];
                    }
                    k--;
                } else {
                    int diff = sum - (array[j] + array[k]);
                    if (diff < minDiff) {
                        minDiff = diff;
                        closestSum = array[i] + array[j] + array[k];
                    }
                    j++;
                }

            }
        }

        return closestSum;
    }
}
