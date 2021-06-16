package problems.medium.backtracking;

import java.util.*;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        combinationSumRec(candidates, 0, result, new ArrayList<>(), target);
        return result;
    }

    private void combinationSumRec(int[] candidates, int index, List<List<Integer>> result,
                                   List<Integer> current, int target)
    {
        if (target < 0 || index == candidates.length) {
            return;
        }

        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        current.add(candidates[index]);
        combinationSumRec(candidates, index, result, current, target - candidates[index]);
        current.remove(current.size() - 1);
        combinationSumRec(candidates, index+1, result, current, target);
    }
}
