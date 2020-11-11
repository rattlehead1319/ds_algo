package bst.tutorials;

public class FixBSTBySwappingTwoNodes {
    Node prev, first, second;
    void fixBST (Node root) {
        if (root == null) {
            return;
        }
        fixBST(root.left);
        if (prev != null && prev.data > root.data) {
            if (first == null) {
                first = prev;
            }
            second = root;
        }
        prev = root;
        fixBST(root.right);
    }
}
