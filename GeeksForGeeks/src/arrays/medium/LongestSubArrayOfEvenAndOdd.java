package arrays.medium;

public class LongestSubArrayOfEvenAndOdd {
    public static int maxEvenOdd(int arr[], int n)
    {
        int len = 1;
        int maxLen = Integer.MIN_VALUE;
        int i = 0;
        while (i < n-1) {
            if ((arr[i] % 2 == 0 && arr[i+1] % 2 != 0) || (arr[i] % 2 != 0 && arr[i+1] % 2 == 0)) {
                len++;
            } else {
                maxLen = Math.max(maxLen, len);
                len = 1;
            }
            i++;
        }
        maxLen = Math.max(maxLen, len);
        return maxLen;
    }
}
