package tree.problems.medium;

public class SumTree {
    boolean isSumTree(Node root)
    {
        if (root == null) {
            return true;
        }

        return isSumTreeRec(root) == Long.MIN_VALUE ? false : true;
    }

    long isSumTreeRec(Node root) {
        if (root == null) {
            return 0;
        }

        int leftSum = (int)isSumTreeRec(root.left);
        if (leftSum == Long.MIN_VALUE) {
            return Long.MIN_VALUE;
        }
        int rightSum = (int)isSumTreeRec(root.right);
        if (rightSum == Long.MIN_VALUE) {
            return Long.MIN_VALUE;
        }
        if ((root.left != null || root.right != null) && root.data != leftSum + rightSum) {
            return Long.MIN_VALUE;
        }
        return root.data + leftSum + rightSum;
    }
}
