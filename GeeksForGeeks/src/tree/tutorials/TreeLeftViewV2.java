package tree.tutorials;

import java.util.*;

public class TreeLeftViewV2 {
    static class Node {
        int data;
        Node left;
        Node right;
    }

    static void printView(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> nodeQ = new LinkedList<>();
        nodeQ.add(root);

        while(!nodeQ.isEmpty()) {
            int count = nodeQ.size();
            for (int index = 0; index < count; index++) {
                Node current = nodeQ.poll();
                if (index == 0) {
                    System.out.println(current.data + " ");
                }
                if (current.left != null) {
                    nodeQ.add(current.left);
                }
                if (current.right != null) {
                    nodeQ.add(current.right);
                }
            }
        }
    }

}
