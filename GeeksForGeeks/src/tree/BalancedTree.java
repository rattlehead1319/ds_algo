package tree;

public class BalancedTree {
    static class Node {
        int data;
        Node left;
        Node right;
    }

    static boolean isBalanced(Node root) {
        return height(root) != -1;
    }

    static int height(Node root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        if (leftHeight == -1) {
            return -1;
        }
        int rightHeight = height(root.right);
        if (rightHeight == -1) {
            return -1;
        }
        if (Math.abs(rightHeight - leftHeight) > 1) {
            return -1;
        }
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
