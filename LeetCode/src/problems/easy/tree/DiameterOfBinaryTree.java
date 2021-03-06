package problems.easy.tree;

class Helper {
    int diameter;
    Helper() {
        diameter = Integer.MIN_VALUE;
    }
}

public class DiameterOfBinaryTree {
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Helper h = new Helper();
        diameterOfBinaryTree(root, h);
        return h.diameter;
    }

    private int diameterOfBinaryTree(TreeNode root, Helper h) {
        if (root == null) {
            return 0;
        }
        int leftHeight = diameterOfBinaryTree(root.left, h);
        int rightHeight = diameterOfBinaryTree(root.right, h);
        int diameter = Integer.MIN_VALUE;
        h.diameter = Math.max(h.diameter, leftHeight + rightHeight);
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
