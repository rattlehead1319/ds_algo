package tree.problems.medium;

import java.util.*;

public class ConnectNodesAtSameLevel {

    static class Node {
        int data;
        Node left;
        Node right;
        Node nextRight;
        Node (int data) {
            this.data = data;
        }
    }
    public static void connect(Node p)
    {
        if (p == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(p);

        while (!queue.isEmpty()) {
            int count = queue.size();
            Node prev = null;
            for (int i = 0; i < count; i++) {
                Node current = queue.poll();
                if (prev != null) {
                    prev.nextRight = current;
                }
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
                prev = current;
            }
            prev.nextRight = null;
        }
    }
}
