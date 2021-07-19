package problems.medium.tree;

import java.util.*;

public class FindDuplicateSubTrees {
    List<TreeNode> result = new ArrayList<>();
    Map<String, Integer> map = new HashMap<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        postOrder(root);
        return result;
    }

    private String postOrder(TreeNode root) {
        if (root == null) {
            return "#";
        }
        String leftTree = postOrder(root.left);
        String rightTree = postOrder(root.right);
        String subTree = root.val + " " + leftTree + rightTree;

        Integer count = map.get(subTree);
        if (count == null) {
            map.put(subTree, 1);
        } else if (count == 1) {
            result.add(root);
            map.put(subTree, count + 1);
        }

        return subTree;
    }
}
