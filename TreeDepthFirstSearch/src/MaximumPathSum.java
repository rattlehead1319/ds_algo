
class MaximumPathSum {

    private static int maxSum = 0;
    public static int findMaximumPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        findMaximumPathSumRecursive(root);
        return maxSum;
    }

    private static int findMaximumPathSumRecursive(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftTreeSum = findMaximumPathSumRecursive(root.left);
        int rightTreeSum = findMaximumPathSumRecursive(root.right);

        leftTreeSum = Math.max(leftTreeSum, 0);
        rightTreeSum = Math.max(rightTreeSum, 0);

        maxSum = Math.max(maxSum, leftTreeSum + rightTreeSum + root.val);

        return Math.max(leftTreeSum,rightTreeSum) + root.val;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println("Maximum Path Sum: " + MaximumPathSum.findMaximumPathSum(root));

        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);
        root.right.right.left = new TreeNode(9);
        System.out.println("Maximum Path Sum: " + MaximumPathSum.findMaximumPathSum(root));

        root = new TreeNode(-1);
        root.left = new TreeNode(-3);
        System.out.println("Maximum Path Sum: " + MaximumPathSum.findMaximumPathSum(root));
    }
}
