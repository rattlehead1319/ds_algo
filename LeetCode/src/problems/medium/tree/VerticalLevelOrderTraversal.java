package problems.medium.tree;

import java.util.*;

public class VerticalLevelOrderTraversal {
    class Helper {
        TreeNode node;
        int hd;
        Helper (TreeNode node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }

        TreeMap<Integer, LinkedList<Integer>> map = new TreeMap<>();
        Queue<Helper> queue = new LinkedList<>();
        queue.add(new Helper(root, 0));

        while(!queue.isEmpty()) {
            int count = queue.size();
            while (count-- > 0) {
                Helper h = queue.poll();
                TreeNode curr = h.node;
                int hd = h.hd;

                if (!map.containsKey(hd)) {
                    map.put(hd, new LinkedList<>());
                }
                map.get(hd).add(curr.val);

                if (curr.left != null) {
                    queue.add(new Helper(curr.left, hd-1));
                }
                if (curr.right != null) {
                    queue.add(new Helper(curr.right, hd+1));
                }
            }
        }

        for (Map.Entry<Integer, LinkedList<Integer>> entry: map.entrySet()) {
            result.add(entry.getValue());
        }

        return result;
    }
}
