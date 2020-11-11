package bst.tutorials;

/***
 * Inorder traversal should give all sorted values
 */

public class CheckBSTv2 {
    int prev = Integer.MIN_VALUE;
    boolean checkBST (Node root) {
        if (root == null) {
            return true;
        }
        if (!checkBST(root.left)) {
            return false;
        }
        if (prev >= root.data) {
            return false;
        }
        prev = root.data;
        return checkBST(root.right);
    }
}
