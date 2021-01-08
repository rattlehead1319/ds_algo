package dynamicprogramming.tutorials;

public class LISLogn {
    public static int lis (int[] arr) {
        int n = arr.length;
        int[] tail = new int[n];
        int len = 1;
        tail[0] = arr[0];

        for (int i = 1; i < n; i++) {
            if (arr[i] > tail[len-1]) {
                tail[len++] = arr[i];
            } else {
                int ceilIndex = getCeilIndex(tail, arr[i], 0, len-1);
                tail[ceilIndex] = arr[i];
            }
        }

        return len;
    }

    private static int getCeilIndex(int[] tail, int x, int left, int right) {
        while (left < right) {
            int middle = left + (right-left)/2;
            if (tail[middle] <= x) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }
        return right;
    }

    public static void main (String[] args) {
        System.out.println(lis(new int[]{3,4,2,8,10,5,1}));
        System.out.println(lis(new int[]{10,5,18,7,2,9}));
    }
}
