package dynamicprogramming.medium;

//This one works, while the one in tutorials package wont for array having duplicate elements

public class LISlogn {
    static int longestSubsequence(int size, int a[]){

        int[] tail = new int[size];
        tail[0] = a[0];
        int len = 1;

        for (int i = 1; i < size; i++) {
            if (a[i] > tail[len-1]) {
                tail[len++] = a[i];
            } else {
                int ceilIndex = ceil(tail, a[i], 0, len-1);
                tail[ceilIndex] = a[i];
            }
        }
        return len;
    }

    static int ceil (int[] arr, int x, int l, int r) {
        while (l < r) {
            int m = l + (r-l)/2;
            if (arr[m] == x) {
                return m;
            }

            if (arr[m] < x) {
                l = m+1;
            } else {
                r = m;
            }
        }
        return r;
    }
}
