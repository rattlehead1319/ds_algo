package tree.problems.medium;

public class MaxDiffBetweenNodeAndAncestor {
    class Result {
        int data = Integer.MIN_VALUE;
    }
    int maxDiff(Node root)
    {
        Result result = new Result();
        maxDiffRec(root, result);
        return result.data;
    }

    int maxDiffRec(Node root, Result result) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }

        if (root.left == null && root.right == null) {
            return root.data;
        }

        int minValue = Math.min(maxDiffRec(root.left, result), maxDiffRec(root.right, result));
        result.data = Math.max(result.data, root.data - minValue);

        return Math.min(root.data, minValue);
    }
}
