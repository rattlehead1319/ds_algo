package backtrack.medium;

import java.util.*;

public class CombinationSum {
    static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B)
    {
        Collections.sort(A);
        ArrayList<Integer> awd = new ArrayList<>(new HashSet<>(A));

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        permute(awd, B, 0, list, result);
        return result;
    }

    static void permute (ArrayList<Integer> A, int targetSum, int index, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> result) {
        if (targetSum == 0) {
            result.add(new ArrayList(list));
            return;
        } else if (targetSum < 0) {
            return;
        }
        while (index < A.size() && A.get(index) <= targetSum) {
            list.add(A.get(index));
            permute(A, targetSum - A.get(index), index, list, result);
            //Backtrack
            list.remove(A.get(index));
            index++;
        }
    }
}
