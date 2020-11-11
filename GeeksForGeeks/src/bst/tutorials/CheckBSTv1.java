package bst.tutorials;

public class CheckBSTv1 {
    boolean checkBST (Node root, int min, int max) {
        if (root == null) {
            return true;
        }
        return (root.data > min && root.data < max &&
                checkBST(root.left, min, root.data) &&
                checkBST(root.right, root.data, max));
    }
}
