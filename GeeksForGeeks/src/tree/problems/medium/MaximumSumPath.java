package tree.problems.medium;

public class MaximumSumPath {
    int maxSum = Integer.MIN_VALUE;

    int findMaxSum(Node node)
    {
        findMaxSumRec(node);
        return maxSum;
    }

    int findMaxSumRec(Node node) {
        if (node == null) {
            return 0;
        }
        int leftSum = findMaxSumRec(node.left);
        int rightSum = findMaxSumRec(node.right);
        int maxSingle =  Math.max(node.data, node.data + Math.max(leftSum, rightSum));
        int maxTop = Math.max(maxSingle, leftSum + rightSum + node.data);
        maxSum = Math.max(maxSum, maxTop);
        return maxSingle;
    }
}
