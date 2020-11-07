package tree;

import java.util.*;

public class MaxTreeWidth {
    static class Node {
        int data;
        Node left;
        Node right;
    }

    static int findMaxWidth(Node root) {
        if (root == null) {
            return 0;
        }

        Queue<Node> nodeQ = new LinkedList<>();
        nodeQ.add(root);
        int maxWidth = Integer.MIN_VALUE;
        while(!nodeQ.isEmpty()) {
            int count = nodeQ.size();
            maxWidth = Math.max(count, maxWidth);
            for (int index = 0; index < count; index++) {
                Node current = nodeQ.poll();
                if (current.left != null) {
                    nodeQ.add(current.left);
                }
                if (current.right != null) {
                    nodeQ.add(current.right);
                }
            }
        }
        return maxWidth;
    }
}

