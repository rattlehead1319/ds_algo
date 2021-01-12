package problems.medium;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
}

public class DistributeCoinsInBinaryTree {
    public int distributeCoins(TreeNode root) {
        int[] result = new int[1];
        distributeCoinsRecursive(root, result);
        return result[0];
    }

    private int distributeCoinsRecursive (TreeNode root, int[] result) {
        if (root == null) {
            return 0;
        }
        int leftMoves = distributeCoinsRecursive(root.left, result);
        int rightMoves = distributeCoinsRecursive(root.right, result);
        result[0] += Math.abs(leftMoves) + Math.abs(rightMoves);
        return root.val + leftMoves + rightMoves - 1;
    }
}
