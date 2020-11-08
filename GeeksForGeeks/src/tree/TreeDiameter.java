package tree;

public class TreeDiameter {
    static class Node {
        int data;
        Node left;
        Node right;
    }

    static int diameter = 0;

    static int getDiameter(Node root) {
        diameter = 0;
        height(root);
        return diameter;
    }

    static int height (Node root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        diameter = Math.max(diameter, 1 + leftHeight + rightHeight);
        return 1 + Math.max(leftHeight, rightHeight);
    }

}
