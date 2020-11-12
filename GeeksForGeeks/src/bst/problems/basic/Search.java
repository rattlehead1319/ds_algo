package bst.problems.basic;

class Node {
    int data;
    Node left;
    Node right;
    Node (int data) {
        this.data = data;
    }
}
public class Search {
    boolean search(Node root, int x)
    {
        if (root == null) {
            return false;
        }
        if (root.data == x) {
            return true;
        } else if (x > root.data && search(root.right, x)) {
            return true;
        } else {
            return search(root.left, x);
        }
    }
}
