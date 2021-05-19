package tree.problems.easy;

import java.util.*;

class Helper1 {
    Node node;
    int ld;
    Helper1 (Node node, int ld) {
        this.node = node;
        this.ld = ld;
    }
}

public class DiagonalSumInBT {
    public static ArrayList <Integer> diagonalSum(Node root)
    {
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Helper1> queue = new LinkedList<>();
        queue.add(new Helper1(root, 0));

        while (!queue.isEmpty()) {

            Helper1 h = queue.poll();
            Node curr = h.node;
            int ld = h.ld;

            Integer val = map.get(ld);
            if (val == null) {
                val = 0;
            }
            map.put(ld, val + curr.data);

            if (curr.left != null) {
                queue.add(new Helper1(curr.left, ld+1));
            }

            if (curr.right != null) {
                queue.add(new Helper1(curr.right, ld));
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            result.add(entry.getValue());
        }
        return result;
    }
}
