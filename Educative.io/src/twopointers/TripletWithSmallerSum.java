package twopointers;

import java.util.*;

public class TripletWithSmallerSum {
    public static int searchTriplets(int[] arr, int target) {
        int count = 0;
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 2; i++) {
            int cnt = getTripletsCount(arr, i+1, target - arr[i]);
            count += cnt;
        }

        return count;
    }

    private static int getTripletsCount(int[] arr, int left, int target) {
        int right = arr.length - 1;
        int count = 0;
        while (left < right) {
            if (arr[left] + arr[right] < target) {
                count += right - left;
                left++;
            } else {
                right--;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(TripletWithSmallerSum.searchTriplets(new int[] { -1, 0, 2, 3 }, 3));
        System.out.println(TripletWithSmallerSum.searchTriplets(new int[] { -1, 4, 2, 1, 3 }, 5));
    }
}