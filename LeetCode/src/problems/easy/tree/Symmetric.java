package problems.easy.tree;

public class Symmetric {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetricRec(root.left, root.right);
    }

    private static boolean isSymmetricRec(TreeNode n1, TreeNode n2) {
        if (n1 == null && n2 == null) {
            return true;
        }

        if (n1 == null || n2 == null) {
            return false;
        }

        return n1.val == n2.val &&
                isSymmetricRec(n1.left, n2.right) &&
                isSymmetricRec(n1.right, n2.left);
    }
}
