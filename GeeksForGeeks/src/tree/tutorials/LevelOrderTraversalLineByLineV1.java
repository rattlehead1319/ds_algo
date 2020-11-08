package tree.tutorials;

import java.util.*;

public class LevelOrderTraversalLineByLineV1 {
    static class Node {
        int data;
        Node left;
        Node right;
    }

    static void traverse (Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> nodeQ = new LinkedList<>();
        nodeQ.add(root);
        nodeQ.add(null);
        while (nodeQ.size() > 1) {
            Node current = nodeQ.poll();
            if (current == null) {
                System.out.println();
                nodeQ.add(null);
                continue;
            }
            if (current.left != null) {
                nodeQ.add(current.left);
            }
            if (current.right != null) {
                nodeQ.add(current.right);
            }
            System.out.println(current.data + " ");
        }
    }

}
