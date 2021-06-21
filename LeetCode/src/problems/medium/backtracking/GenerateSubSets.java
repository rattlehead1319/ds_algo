package problems.medium.backtracking;

import java.util.*;

//Theres a better algorithm using bitmasking..Visit Leetcode

public class GenerateSubSets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        genrateUniqueSets(nums, 0, new ArrayList(), result);
        return result;
    }

    private void genrateUniqueSets (int[] nums, int index, List<Integer> curr,
                                    List<List<Integer>> result)
    {
        result.add(new ArrayList(curr));

        for (int i = index; i < nums.length; i++) {
            curr.add(nums[i]);

            genrateUniqueSets(nums, i+1, curr, result);

            //backtrack
            curr.remove(curr.size() - 1);
        }
    }
}
