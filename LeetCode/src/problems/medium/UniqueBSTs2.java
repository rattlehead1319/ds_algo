package problems.medium;

import java.util.*;

//Must visit

public class UniqueBSTs2 {
    public List<TreeNode> generateTrees(int n) {

        List<TreeNode> list = new ArrayList<>();
        if (n == 0) {
            return list;
        }
        return generateTreesRec(1, n);
    }

    private List<TreeNode> generateTreesRec(int start, int end) {
        List<TreeNode> tree = new ArrayList<>();
        if (start > end) {
            tree.add(null);
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftList = generateTreesRec(start, i-1);
            List<TreeNode> rightList = generateTreesRec(i+1, end);

            for (TreeNode left: leftList) {
                for (TreeNode right: rightList) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    tree.add(root);
                }
            }
        }
        return tree;
    }
}
