package searching.medium;

public class MaxWaterBetweenTwoBuildings {
    static int maxWater(int height[], int n)
    {
        int maxWater = 0;
        int left = 0;
        int right = n-1;

        while (right - left > 1) {

            int minHeight = Math.min(height[left], height[right]);
            int water = minHeight * (right-left-1);
            maxWater = Math.max(maxWater, water);
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return maxWater;
    }
}
