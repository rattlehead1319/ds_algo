package bst.tutorials;

import javax.swing.text.html.parser.Entity;
import java.util.*;

class Pair {
    Node node;
    int horizontalDistance;
    Pair (Node node, int horizontalDistance) {
        this.node = node;
        this.horizontalDistance = horizontalDistance;
    }
}
public class BinaryTreeVerticalTraversal {
    void verticalTraversal(Node root) {
        if (root == null) {
            return;
        }
        Map<Integer, List<Integer>> treeMap = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();
        Pair pair = new Pair(root, 0);
        queue.add(pair);

        while (!queue.isEmpty()) {
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                Pair current = queue.poll();
                int hd = current.horizontalDistance;
                if (treeMap.containsKey(hd)) {
                    List<Integer> list = treeMap.get(hd);
                    list.add(current.node.data);
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(current.node.data);
                    treeMap.put(hd, list);
                }
                if (current.node.left != null) {
                    queue.add(new Pair(current.node.left, hd - 1));
                }
                if (current.node.right != null) {
                    queue.add(new Pair(current.node.right, hd + 1));
                }
            }
        }

        for (Map.Entry<Integer, List<Integer>> entry: treeMap.entrySet()) {
            List<Integer> list = entry.getValue();
            for (Integer val : list) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
