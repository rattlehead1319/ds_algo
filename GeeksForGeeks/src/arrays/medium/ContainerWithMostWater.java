package arrays.medium;

public class ContainerWithMostWater {
    long maxArea(int A[], int len){

        int left = 0;
        int right = len - 1;
        int maxWater = Integer.MIN_VALUE;
        while (left < right) {
            int water = Math.min(A[right], A[left]) * (right - left);
            maxWater = Math.max(water, maxWater);
            if (A[left] <= A[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxWater == Integer.MIN_VALUE ? 0 : maxWater;
    }
}
