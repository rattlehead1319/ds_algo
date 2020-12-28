package arrays.easy;

import java.util.*;

public class MaxAndSecondMax {
    public static ArrayList<Integer> largestAndSecondLargest(int sizeOfArray, int arr[])
    {
        int max = arr[0];
        int secondMax = -1;

        for (int i = 1; i < sizeOfArray; i++) {
            if (arr[i] > max) {
                secondMax = max;
                max = arr[i];
            } else if (arr[i] < max && arr[i] > secondMax) {
                secondMax = arr[i];
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        result.add(max);
        result.add(secondMax);

        return result;
    }
}
