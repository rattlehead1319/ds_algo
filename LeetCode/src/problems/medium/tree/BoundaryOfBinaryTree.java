package problems.medium.tree;

import java.util.*;

public class BoundaryOfBinaryTree {
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> leftBoundary = new ArrayList<>();
        List<Integer> rightBoundary = new ArrayList<>();
        List<Integer> leaves = new ArrayList<>();

        preOrder(root, leftBoundary, rightBoundary, leaves, 0);
        leftBoundary.addAll(leaves);
        leftBoundary.addAll(rightBoundary);

        return leftBoundary;
    }

    private void preOrder(TreeNode current, List<Integer> leftBoundary,
                          List<Integer> rightBoundary,
                          List<Integer> leaves, int flag)
    {
        if (current == null) {
            return;
        }
        if (isRightBoundary(flag)) {
            rightBoundary.add(0, current.val);
        } else if (isLeftBoundary(flag) || isRoot(flag)) {
            leftBoundary.add(current.val);
        } else if (isLeaf(current)) {
            leaves.add(current.val);
        }
        preOrder(current.left, leftBoundary, rightBoundary, leaves, leftChildFlag(current, flag));
        preOrder(current.right, leftBoundary, rightBoundary, leaves, rightChildFlag(current, flag));
    }

    private boolean isRightBoundary(int flag) {
        return flag == 2;
    }

    private boolean isLeftBoundary(int flag) {
        return flag == 1;
    }

    private boolean isRoot(int flag) {
        return flag == 0;
    }

    private boolean isLeaf(TreeNode current) {
        return current.left == null && current.right == null;
    }

    private int leftChildFlag(TreeNode current, int flag) {
        if (isLeftBoundary(flag) || isRoot(flag)) {
            return 1;
        } else if (isRightBoundary(flag) && current.right == null) {
            return 2;
        }
        return 3;
    }

    private int rightChildFlag(TreeNode current, int flag) {
        if (isRightBoundary(flag) || isRoot(flag)) {
            return 2;
        } else if (isLeftBoundary(flag) && current.left == null) {
            return 1;
        }
        return 3;
    }
}
