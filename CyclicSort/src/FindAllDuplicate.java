import java.util.*;

public class FindAllDuplicate {

    public static List<Integer> findNumbers(int[] nums) {
        List<Integer> duplicateNumbers = new ArrayList<>();

        int i = 0;
        while (i < nums.length) {
            int j = nums[i] - 1;
            if (nums[i] != nums[j])
                Utility.swap(nums, i, j);
            else
                i++;
        }


        for (i = 0; i < nums.length; i++) {
            if (i + 1 != nums[i]) {
                duplicateNumbers.add(nums[i]);
            }
        }
        return duplicateNumbers;
    }

    public static void main(String[] args) {
        List<Integer> duplicates = FindAllDuplicate.findNumbers(new int[] { 3, 4, 4, 5, 5 });
        System.out.println("Duplicates are: " + duplicates);

        duplicates = FindAllDuplicate.findNumbers(new int[] { 5, 4, 7, 2, 3, 5, 3 });
        System.out.println("Duplicates are: " + duplicates);
    }

}
