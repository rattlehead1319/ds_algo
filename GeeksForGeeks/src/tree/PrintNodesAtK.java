package tree;

public class PrintNodesAtK {
    static class Node {
        int data;
        Node left;
        Node right;
    }

    static void printNodes(Node root, int k) {
        if (root == null) {
            return;
        }
        if (k == 0) {
            System.out.println(root.data + " ");;
        } else {
            printNodes(root.left, k-1);
            printNodes(root.right, k-1);
        }
    }

}
