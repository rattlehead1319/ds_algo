package problems.easy.tree;

public class SubTreeOfAnotherTree {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        } else if (isSameTrees(root, subRoot)) {
            return true;
        } else {
            return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        }
    }

    private boolean isSameTrees(TreeNode root, TreeNode subRoot) {
        if (root == null || subRoot == null) {
            return root == null && subRoot == null;
        }

        return root.val == subRoot.val &&
                isSameTrees(root.left, subRoot.left) &&
                isSameTrees(root.right, subRoot.right);
    }
}
