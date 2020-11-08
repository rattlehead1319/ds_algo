package tree.tutorials;

public class ChildrenSum {
    static class Node {
        int data;
        Node left;
        Node right;
    }

    static boolean hasChildrenSumProperty(Node root) {
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }
        int left = 0;
        int right = 0;
        if (root.left != null) {
            left = root.left.data;
        }
        if (root.right != null) {
            right = root.right.data;
        }
        return root.data == (left + right) &&
                hasChildrenSumProperty(root.left) &&
                hasChildrenSumProperty(root.right);
    }
}
