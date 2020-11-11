package bst.tutorials;

public class Ceil {
    static Node floor (Node root, int x) {
        if (root == null) {
            return null;
        }
        Node result = null;
        while (root != null) {
            if (root.data == x) {
                return root;
            } else if (x > root.data) {
                root = root.right;
            } else if (x < root.data) {
                result = root;
                root = root.left;
			}
        }
        return result;
    }
}
