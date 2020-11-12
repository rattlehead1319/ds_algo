package bst.problems.medium;

class Node {
    int data;
    Node left;
    Node right;
}
public class DeleteNode {
    // Return the root of the modified BST after deleting the node with value X
    public static Node deleteNode(Node root, int X)
    {
        if (root == null) {
            return null;
        }

        if (X > root.data) {
            root.right = deleteNode(root.right, X);
        } else if (X < root.data) {
            root.left = deleteNode(root.left, X);
        } else {
            //If we the node to be deleted as two children
            if (root.left != null && root.right != null) {
                Node temp = root;
                Node minValFromNode = minVal(temp.right);
                root.data = minValFromNode.data;
                root.right = deleteNode(root.right, minValFromNode.data);
            } else if (root.left != null) { //Only has left child
                root = root.left;
            } else if (root.right != null) {//Only has right child
                root =root.right;
            } else { // Leaf node, has no child
                root = null;
            }
        }
        return root;
    }

    private static Node minVal(Node root) {
        if (root.left == null) {
            return root;
        }
        return minVal(root.left);
    }
}
