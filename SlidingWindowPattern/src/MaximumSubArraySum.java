public class MaximumSubArraySum {
    public static int findMaxSumSubArray(int k, int[] arr) {
        int start = 0;
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (i == start + k-1) {
                maxSum = Math.max(maxSum, sum);
                sum -= arr[start];
                start++;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println("Maximum sum of a subarray of size K: "
                + MaximumSubArraySum.findMaxSumSubArray(3, new int[] { 2, 1, 5, 1, 3, 2 }));
        System.out.println("Maximum sum of a subarray of size K: "
                + MaximumSubArraySum.findMaxSumSubArray(2, new int[] { 2, 3, 4, 1, 5 }));
    }
}
