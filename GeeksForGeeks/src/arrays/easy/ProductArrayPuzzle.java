package arrays.easy;

public class ProductArrayPuzzle {
    public static long[] productExceptSelf(int nums[], int n)
    {
        int numberOfZeroes = 0;
        long product = 1;
        int zeroIndex = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                numberOfZeroes++;
                zeroIndex = i;
            } else {
                product *= (long)nums[i];
            }
        }

        long[] result = new long[n];
        if (numberOfZeroes > 1) {
            return result;
        } else if (numberOfZeroes == 1) {
            result[zeroIndex] = product;
        } else {
            for (int i = 0; i < n; i++) {
                result[i] = product / (long)nums[i];
            }
        }

        return result;
    }
}
