package problems.easy.tree;

public class MinDepth {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int x = minDepthRec(root);
        return x == Integer.MAX_VALUE ? 0 : x;
    }

    private int minDepthRec(TreeNode root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return 1 + Math.min(minDepthRec(root.left), minDepthRec(root.right));
    }
}
