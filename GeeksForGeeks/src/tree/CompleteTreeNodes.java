package tree;

/***
 * Time complexity is O(logn * logn), should be noticed y
 */
public class CompleteTreeNodes {
    static class Node {
        int data;
        Node left;
        Node right;
    }

    static int countNodes (Node root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = 0;
        Node current = root;
        while (current != null) {
            current = current.left;
            leftHeight++;
        }

        int rightHeight = 0;
        current = root;
        while (current != null) {
            current = current.right;
            rightHeight++;
        }

        if (leftHeight == rightHeight) {
            return (int)Math.pow(2, leftHeight) - 1;
        } else {
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }

}
