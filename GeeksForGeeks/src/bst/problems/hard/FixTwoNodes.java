package bst.problems.hard;

class Node {
    int data;
    Node left;
    Node right;
}

public class FixTwoNodes {
    class Helper {
        Node prev, first, second;
    }
    public Node correctBST(Node root)
    {
        if (root == null) {
            return null;
        }
        Helper h = new Helper();
        correctBSTRec(root, h);
        int temp = h.first.data;
        h.first.data = h.second.data;
        h.second.data = temp;
        return root;
    }

    private void correctBSTRec(Node root, Helper h) {
        if (root == null) {
            return;
        }
        correctBSTRec(root.left, h);
        if (h.prev != null && h.prev.data > root.data) {
            if (h.first == null) {
                h.first = h.prev;
            }
            h.second = root;
        }
        h.prev = root;
        correctBSTRec(root.right, h);
    }
}
