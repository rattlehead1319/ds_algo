package linkedlist;

import java.util.*;

public class LevelOrderTraversalLineByLineV2 {
    static class Node {
        int data;
        Node left;
        Node right;
    }

    static void traverse (Node root) {
        Queue<Node> nodeQ = new LinkedList<>();
        nodeQ.add(root);

        while (!nodeQ.isEmpty()) {
            int count = nodeQ.size();
            for (int index = 0; index < count; index++) {
                Node current = nodeQ.poll();
                if (current.left != null) {
                    nodeQ.add(current.left);
                }
                if (current.right != null) {
                    nodeQ.add(current.right);
                }
                System.out.println(current.data + " ");
            }
            System.out.println();
        }
    }

}
