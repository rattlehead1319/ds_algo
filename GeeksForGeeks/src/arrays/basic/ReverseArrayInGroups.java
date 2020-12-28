package arrays.basic;

import java.util.*;

public class ReverseArrayInGroups {
    void reverseInGroups(ArrayList<Integer> arr, int n, int k) {
        if (k > n) {
            k = n;
        }
        int low = 0;
        int high = low+k-1;
        while (high <= n-1) {
            reverse(arr, low, high);
            if (high == n-1) {
                break;
            }
            low = high + 1;
            high = high+k > n-1 ? n-1 : high+k;
        }
    }

    void reverse (ArrayList<Integer> arr, int low, int high) {
        int mid = (low+high)/2;
        int left = (high-low+1)%2 == 0 ? mid : mid-1;
        int right = mid+1;

        while (left >= low && right <= high) {
            int temp = arr.get(left);
            arr.set(left, arr.get(right));
            arr.set(right, temp);
            left--;
            right++;
        }
    }
}
