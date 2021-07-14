package problems.medium.array;

public class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int noOfZeros = 0;
        int product = 1;
        int productIndex = -1;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num == 0) {
                noOfZeros++;
                productIndex = i;
            } else {
                product *= num;
            }
        }
        if (noOfZeros > 1) {
            return result;
        } else if (noOfZeros == 1) {
            result[productIndex] = product;
            return result;
        }

        for (int i = 0; i < nums.length; i++) {
            result[i] = product/nums[i];
        }
        return result;
    }
}
