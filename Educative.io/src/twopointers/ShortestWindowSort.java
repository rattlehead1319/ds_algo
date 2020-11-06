package twopointers;

public class ShortestWindowSort {

    public static int sort(int[] arr) {

        int left = 0;
        int right = arr.length - 1;

        while (left < arr.length - 1  && arr[left] < arr[left + 1]) {
            left++;
        }

        //array is already sorted
        if (left == arr.length - 1) {
            return 0;
        }

        while (right > 0 && arr[right - 1] < arr[right]) {
            right--;
        }

        int min = Integer.MAX_VALUE;
        int max  = Integer.MIN_VALUE;
        for (int i = left; i <= right; i++) {
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }

        while (left > 0 && arr[left - 1] > min) {
            left--;
        }
        while (right < arr.length - 1 && arr[right + 1] < max) {
            right++;
        }
        return right - left + 1;
    }

    public static void main(String[] args) {
        System.out.println(ShortestWindowSort.sort(new int[] { 1, 2, 5, 3, 7, 10, 9, 12 }));
        System.out.println(ShortestWindowSort.sort(new int[] { 1, 3, 2, 0, -1, 7, 10 }));
        System.out.println(ShortestWindowSort.sort(new int[] { 1, 2, 3 }));
        System.out.println(ShortestWindowSort.sort(new int[] { 3, 2, 1 }));
    }
}
