package bst.tutorials;

import java.util.*;

class BinaryTreeBottomView {
    static class Pair {
        Node node;
        int horizontalDist;
        Pair (Node node, int horizontalDist) {
            this.node = node;
            this.horizontalDist = horizontalDist;
        }
    }

    void printBottomView (Node root) {
        if (root == null) {
            return;
        }

        Map<Integer, Integer> treeMap = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));

        while (!queue.isEmpty()) {
            int count = queue.size();
            for (int index = 0; index < count; index++) {
                Pair current = queue.poll();
                Node node = current.node;
                int horizontalDist = current.horizontalDist;

                treeMap.put(horizontalDist, node.data);
                if (node.left != null) {
                    queue.add(new Pair(node.left, horizontalDist - 1));
                }
                if (node.right != null) {
                    queue.add(new Pair(node.right, horizontalDist + 1));
                }
            }
        }

        for (Map.Entry<Integer, Integer> entry: treeMap.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
}

