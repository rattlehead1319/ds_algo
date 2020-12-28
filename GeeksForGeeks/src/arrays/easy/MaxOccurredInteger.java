package arrays.easy;

public class MaxOccurredInteger {
    public static int maxOccured(int L[], int R[], int n, int maxx){
        int[] arr = new int[1000000];
        for (int i = 0; i < n; i++) {
            arr[L[i]]++;
            arr[R[i]+1]--;
        }
        int val = Integer.MIN_VALUE;
        int index = -1;
        for (int i = 1; i < 1000000; i++) {
            arr[i] += arr[i-1];
            if (arr[i] > val) {
                val = arr[i];
                index = i;
            }
        }
        return index;
    }
}
