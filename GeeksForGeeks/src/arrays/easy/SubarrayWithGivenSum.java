package arrays.easy;

import java.util.*;

public class SubarrayWithGivenSum {
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s)
    {
        ArrayList<Integer> result = new ArrayList<>();
        int i = 0;
        int j = i + 1;
        int sum = arr[i];
        while (i < n && j < n) {
            if (sum == s) {
                result.add(i + 1);
                result.add(j);
                return result;
            } else if (sum > s) {
                sum -= arr[i++];
            } else {
                sum += arr[j++];
            }
        }

        if (sum > s) {
            while (i < j) {
                sum -= arr[i++];
                if (sum == s) {
                    result.add(i + 1);
                    result.add(j);
                    return result;
                }
            }
        }

        result.add(-1);
        return result;
    }
}
