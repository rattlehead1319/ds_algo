package problems.hard.tree;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Helper {
    int maxSum;
    Helper() {
        maxSum = Integer.MIN_VALUE;
    }
}

public class MaxPathSum {
    public int maxPathSum(TreeNode root) {
        Helper h = new Helper();
        maxPathSumRec(root, h);
        return h.maxSum;
    }

    private int maxPathSumRec(TreeNode root, Helper h) {
        if (root == null) {
            return 0;
        }

        int leftSum = Math.max(maxPathSumRec(root.left, h), 0);
        int rightSum = Math.max(maxPathSumRec(root.right, h), 0);

        int newPathSum = root.val + leftSum + rightSum;
        h.maxSum = Math.max(h.maxSum, newPathSum);

        return root.val + Math.max(leftSum, rightSum);
    }
}
