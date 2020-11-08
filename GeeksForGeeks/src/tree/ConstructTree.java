package tree;

/**
 * Visit again and again
 */

public class ConstructTree {
    static class Node {
        int data;
        Node left;
        Node right;
        Node (int data) {
            this.data = data;
        }
    }
    static int preIndex = 0;

    static Node construct (int[] inOrder, int[] preOrder) {
        preIndex = 0;
        return constructRec(inOrder, preOrder, 0, inOrder.length);
    }

    static Node constructRec (int[] inOrder, int[] preOrder, int start, int end) {
        if (start > end) {
            return null;
        }
        Node root = new Node(preOrder[preIndex++]);
        int inIndex = 0;
        for (int index = start; index <= end; index++) {
            if (inOrder[index] == root.data) {
                inIndex = index;
                break;
            }
        }
        root.left = constructRec(inOrder, preOrder, start, inIndex - 1);
        root.right = constructRec(inOrder, preOrder, inIndex + 1, end);
        return root;
    }
}
