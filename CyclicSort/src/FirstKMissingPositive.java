import java.util.*;

public class FirstKMissingPositive {
    public static List<Integer> findNumbers(int[] nums, int k) {
        List<Integer> missingNumbers = new ArrayList<>();

        int max = Integer.MIN_VALUE;
        List<Integer> dummy = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            dummy.add(nums[i]);
        }

        int diff = max - nums.length;
        for (int i = 0; i < diff; i++) {
            dummy.add(0);
        }

        Integer[] modNums = new Integer[dummy.size()];
        modNums = dummy.toArray(modNums);

        int i = 0;
        while (i < modNums.length) {
            int j = modNums[i] - 1;
            if (i >= 0 && j >= 0 && j < modNums.length && modNums[i] != modNums[j])
                swap(modNums, i, j);
            else
                i++;
        }

        i = 0;
        while (k > 0 && i < modNums.length) {
            if (i+1 != modNums[i]) {
                missingNumbers.add(i+1);
                k--;
            }
            i++;
        }
        i++;
        while (k > 0) {
            missingNumbers.add(i++);
            k--;
        }
        return missingNumbers;
    }

    private static void swap(Integer[] nums, int x, int y) {
        int temp = nums[y];
        nums[y] = nums[x];
        nums[x] = temp;
    }

    public static void main(String[] args) {
        List<Integer> missingNumbers = FirstKMissingPositive.findNumbers(new int[] { 3, -1, 4, 5, 5 }, 3);
        System.out.println("Missing numbers: " + missingNumbers);

        missingNumbers = FirstKMissingPositive.findNumbers(new int[] { 2, 3, 4 }, 3);
        System.out.println("Missing numbers: " + missingNumbers);

        missingNumbers = FirstKMissingPositive.findNumbers(new int[] { -2, -3, 4 }, 2);
        System.out.println("Missing numbers: " + missingNumbers);
    }

}
