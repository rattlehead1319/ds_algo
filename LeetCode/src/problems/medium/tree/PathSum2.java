package problems.medium.tree;

import java.util.*;

public class PathSum2 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList();
        if (root == null) {
            return result;
        }

        List<Integer> curr = new ArrayList<>();
        pathSumRec(root, targetSum, curr, result);
        return result;
    }

    private void pathSumRec(TreeNode root, int sum, List<Integer> curr, List<List<Integer>> result) {
        if (root == null) {
            return;
        }
        curr.add(root.val);
        if (root.val == sum && root.left == null && root.right == null) {
            result.add(new ArrayList<>(curr));
        }
        pathSumRec(root.left, sum - root.val, curr, result);
        pathSumRec(root.right, sum - root.val, curr, result);
        //Backtrack
        curr.remove(curr.size()-1);
    }
}
