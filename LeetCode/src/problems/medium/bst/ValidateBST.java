package problems.medium.bst;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) { this.val = val; }
}

public class ValidateBST {
    public boolean isValidBST(TreeNode root) {
        long min = Long.MIN_VALUE;
        long max = Long.MAX_VALUE;

        return isValidBSTRec(root, min, max);
    }

    private boolean isValidBSTRec(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }

        return (long)root.val > min && (long)root.val < max &&
                isValidBSTRec(root.left, min, root.val) &&
                isValidBSTRec(root.right, root.val, max);
    }
}
