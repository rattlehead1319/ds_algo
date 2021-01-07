package dynamicprogramming.tutorials;

public class LongestIncreasingSubsequence {
    public static int findLIS (int[] arr) {
        int n = arr.length;
        int[] lis = new int[n];
        lis[0] = 1;
        int max = 1;

        for (int i = 1; i < n; i++) {
            int maxVal = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++) {
                int val = 1;
                if (arr[j] <= arr[i] ) {
                    val += lis[j];
                }
                maxVal = Math.max(val, maxVal);
            }
            lis[i] = maxVal;
            max = Math.max(max, lis[i]);
        }
        
        return max;
    }

    public static void main (String[] args) {
        System.out.println(findLIS(new int[]{3,4,2,8,10,5,1}));
    }
}
