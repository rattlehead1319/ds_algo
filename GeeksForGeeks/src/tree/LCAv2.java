package tree;

/**
 * This solution assumes that both integers are present in the binary tree
 * and four scenarios:
 * 1) LCA is same as n1 or n2
 * 2) One of the subtrees has n1 and other subtree has n2
 * 3) One of the subtrees has both n1 and n2
 * 4) None of the subtrees has both n1 and n2
 */

public class LCAv2 {

    static class Node {
        int data;
        Node left;
        Node right;
    }

    static Node findLCA (Node root, int num1, int num2) {
        if (root == null) {
            return null;
        }

        if (root.data == num1 || root.data == num2) {
            return root;
        }

        Node lca1 = findLCA(root.left, num1, num2);
        Node lca2 = findLCA(root.right, num1, num2);

        if (lca1 != null && lca2 != null) {
            return root;
        }
        if (lca1 != null) {
            return lca1;
        } else {
            return lca2;
        }
    }
}
