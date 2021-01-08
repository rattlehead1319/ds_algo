package dynamicprogramming.tutorials;

public class LongestIncreasingSubsequence {
    public static int findLIS (int[] arr) {
        int n = arr.length;
        int[] lis = new int[n];
        lis[0] = 1;
        int max = 1;

        for (int i = 1; i < n; i++) {
            lis[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i] ) {
                    lis[i] = Math.max(lis[i], lis[j] + 1);
                }
            }
            max = Math.max(max, lis[i]);
        }

        return max;
    }

    public static void main (String[] args) {
        System.out.println(findLIS(new int[]{3,4,2,8,10,5,1}));
        System.out.println(findLIS(new int[]{10,5,18,7,2,9}));
    }
}
