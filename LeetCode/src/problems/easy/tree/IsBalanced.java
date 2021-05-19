package problems.easy.tree;

public class IsBalanced {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        return isBalancedRec(root) == -1 ? false: true;
    }

    private int isBalancedRec(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = isBalancedRec(root.left);
        if (leftHeight == -1) {
            return -1;
        }
        int rightHeight = isBalancedRec(root.right);
        if (rightHeight == -1) {
            return -1;
        }
        if (Math.abs(rightHeight - leftHeight) > 1) {
            return -1;
        }
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
