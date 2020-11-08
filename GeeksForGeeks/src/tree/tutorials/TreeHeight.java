package tree.tutorials;

public class TreeHeight {
    static class Node {
        int data;
        Node left;
        Node right;
    }

    static int getHeight(Node root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }
}
