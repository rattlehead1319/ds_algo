package tree.problems.easy;

import java.util.*;

class Helper {
    Node node;
    int hd;
    Helper(Node node, int hd) {
        this.node = node;
        this.hd = hd;
    }
}

public class VerticalSum {
    public ArrayList <Integer> verticalSum(Node root) {

        ArrayList<Integer> result = new ArrayList<>();
        Map<Integer, Integer> map = new TreeMap<>();
        if (root == null) {
            return result;
        }

        Queue<Helper> queue = new LinkedList<>();
        queue.add(new Helper(root, 0));

        while (!queue.isEmpty()) {
            Helper h = queue.poll();

            Node curr = h.node;
            int currHd = h.hd;

            Integer val = map.get(currHd);
            if (val == null) {
                val = 0;
            }
            map.put(currHd, val + curr.data);

            if (curr.left != null) {
                queue.add(new Helper(curr.left, currHd - 1));
            }
            if (curr.right != null) {
                queue.add(new Helper(curr.right, currHd + 1));
            }
        }

        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            result.add(entry.getValue());
        }
        return result;
    }
}
