package problems.medium.binarysearch;

import java.util.*;

public class FindkClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0;
        int right = arr.length - 1;

        List<Integer> result = new ArrayList<>();

        if (x < arr[0]) {
            for (int i = 0; i < k; i++) {
                result.add(arr[i]);
            }
            return result;
        } else if (x > arr[arr.length - 1]) {
            for (int i = arr.length - k; i < arr.length ; i++) {
                result.add(arr[i]);
            }
            return result;
        }

        while (left <= right) {
            int mid = left + (right - left) /2;
            if (arr[mid] == x) {
                result.add(x);
                getClosestElements(arr, k, x, mid - 1, mid + 1, result);
                break;
            } else if (arr[mid] > x) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        if (arr[left] > x) {
            getClosestElements(arr, k, x, left - 1, left, result);
        } else {
            getClosestElements(arr, k, x, left, left + 1, result);
        }

        Collections.sort(result);
        return result;
    }

    private void getClosestElements(int[] arr, int k, int x, int left, int right, List<Integer> result) {
        while (left >= 0 && right < arr.length && result.size() != k) {
            if (Math.abs(arr[left] - x) == Math.abs(arr[right] - x) || Math.abs(arr[left] - x) < Math.abs(arr[right] - x)) {
                result.add(arr[left--]);
            } else {
                result.add(arr[right++]);
            }
        }
        while (right < arr.length && result.size() != k) {
            result.add(arr[right++]);
        }
        while (left >= 0 && result.size() != k) {
            result.add(arr[left--]);
        }
    }
}
