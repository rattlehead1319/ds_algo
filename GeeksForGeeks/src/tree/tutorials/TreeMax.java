package tree.tutorials;

public class TreeMax {
    static class Node {
        int data;
        Node left;
        Node right;
    }

    static int getMax(Node root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        return Math.max(root.data, Math.max(getMax(root.left), getMax(root.right)));
    }
}
