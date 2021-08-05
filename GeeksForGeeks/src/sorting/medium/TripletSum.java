package sorting.medium;

import java.util.*;

public class TripletSum {
    public static int find3Numbers(int arr[], int N, int X) {

        Arrays.sort(arr);

        for (int i = 0; i < N-1; i++) {
            int left = i+1;
            int right = N-1;
            int sum = X - arr[i];
            if (sum < 0) {
                return 0;
            }
            while (left < right) {
                if (arr[left] + arr[right] == sum) {
                    return 1;
                } else if (arr[left] + arr[right] > sum) {
                    right--;
                } else {
                    left++;
                }
            }
        }

        return 0;
    }
}
