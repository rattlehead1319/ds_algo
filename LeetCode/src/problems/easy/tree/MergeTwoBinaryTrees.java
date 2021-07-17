package problems.easy.tree;

public class MergeTwoBinaryTrees {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return mergeTreesRec(root1, root2);
    }

    private TreeNode mergeTreesRec(TreeNode root1, TreeNode root2) {
        TreeNode current = null;
        if (root1 == null && root2 == null) {
            return null;
        } else if (root1 != null && root2 == null) {
            current = new TreeNode(root1.val);
        } else if (root1 == null && root2 != null) {
            current = new TreeNode(root2.val);
        } else {
            current = new TreeNode(root1.val + root2.val);
        }
        TreeNode leftRoot1 = root1 != null ? root1.left : null;
        TreeNode leftRoot2 = root2 != null ? root2.left : null;
        current.left = mergeTreesRec(leftRoot1, leftRoot2);

        TreeNode rightRoot1 = root1 != null ? root1.right : null;
        TreeNode rightRoot2 = root2 != null ? root2.right : null;
        current.right = mergeTreesRec(rightRoot1, rightRoot2);

        return current;
    }
}
