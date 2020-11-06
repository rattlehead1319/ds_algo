package twopointers;

public class TripletSumCloseToTarget {
    public static int searchTriplet(int[] arr, int targetSum) {

        int closestSum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length-2; i++) {
           if (i > 0 && arr[i] == arr[i-1]) { // skip same element to avoid duplicate triplets
               continue;
           }
           int cs = getClosestSum(arr, i+1, targetSum - arr[i]);
           closestSum = Math.max(closestSum, targetSum - Math.abs(cs));
        }
        return closestSum;
    }

    private static int getClosestSum(int[] arr, int left, int targetSum) {
        int right = arr.length - 1;
        int minDiff = Integer.MAX_VALUE;
        while (left < right) {
            int currentSum = arr[left] + arr[right];
            minDiff = Math.min(minDiff, (targetSum - currentSum));
            if (currentSum < targetSum) {
                left++;
            } else {
                right--;
            }
        }
        return minDiff;
    }

    public static void main(String[] args) {
        System.out.println(TripletSumCloseToTarget.searchTriplet(new int[] { -2, 0, 1, 2 }, 2));
        System.out.println(TripletSumCloseToTarget.searchTriplet(new int[] { -3, -1, 1, 2 }, 1));
        System.out.println(TripletSumCloseToTarget.searchTriplet(new int[] { 1, 0, 1, 1 }, 100));
    }

}
