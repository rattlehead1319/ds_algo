package tree.problems.easy;

import java.util.*;

class Helper3 {
    Node node;
    int parent;
    Helper3 (Node node, int parent) {
        this.node = node;
        this.parent = parent;
    }
}

public class IsCousins {

    public boolean isCousins(Node root, int a, int b) {

        if (root == null) {
            return false;
        }

        Queue<Helper3> queue = new LinkedList<>();
        queue.add(new Helper3(root, -1));

        while (!queue.isEmpty()) {
            int count = queue.size();
            int  parentA = -1;
            int  parentB = -1;
            for (int i = 0; i < count; i++) {
                Helper3 h = queue.poll();
                Node curr = h.node;
                int parent = h.parent;

                if (curr.data == a) {
                    parentA = parent;
                }

                if (curr.data == b) {
                    parentB = parent;
                }

                if (parentA != -1 && parentB != -1 && parentA != parentB) {
                    return true;
                }

                if (curr.left != null) {
                    queue.add(new Helper3(curr.left, curr.data));
                }

                if (curr.right != null) {
                    queue.add(new Helper3(curr.right, curr.data));
                }
            }
        }

        return false;
    }
}
