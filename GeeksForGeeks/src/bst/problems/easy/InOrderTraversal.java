package bst.problems.easy;

import java.util.*;

class Node {
    int data;
    Node left;
    Node right;
}

public class InOrderTraversal {
    ArrayList<Integer> inOrder(Node root)
    {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        inOrderRec(root, result);
        return result;
    }

    void inOrderRec(Node root, ArrayList<Integer> result) {
        if (root == null) {
            return;
        }
        inOrderRec(root.left, result);
        result.add(root.data);
        inOrderRec(root.right, result);
    }
}
