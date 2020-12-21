package sorting.easy;

public class Closet0s1sAnd2s {
    public static void segragate012(int arr[], int N){
        int low = 0;
        int mid = 0;
        int high = N-1;

        while (mid <= high) {
            switch (arr[mid]) {
                case 0: swap(arr, low, mid);
                    low++; mid++;
                    break;
                case 1: mid++;
                    break;
                case 2: swap(arr, mid, high);
                    high--;
                    break;
            }
        }
    }

    private static void swap (int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
