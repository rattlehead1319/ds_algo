package tree;

public class TreeLeftViewV1 {
    static class Node {
        int data;
        Node left;
        Node right;
    }

    static int maxLevel = 0;
    static void printView(Node root) {
        maxLevel = 0;
        printViewRec(root, 1);
    }

    static void printViewRec(Node root, int level) {
        if (root == null) {
            return;
        }
        if (maxLevel < level) {
            System.out.println(root.data + " ");
            maxLevel = level;
        }
        printViewRec(root.left, level + 1);
        printViewRec(root.right, level + 1);
    }
}
