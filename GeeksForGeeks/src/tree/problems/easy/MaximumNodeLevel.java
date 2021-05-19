package tree.problems.easy;

import java.util.*;

public class MaximumNodeLevel {
    public static int maxNodeLevel(Node root)
    {
        if (root == null) {
            return 0;
        }
        Queue<Node> queue = new LinkedList<>();
        int res = Integer.MIN_VALUE;

        queue.add(root);
        int level = 0;
        int resultLevel = 0;

        while (!queue.isEmpty()) {
            int count = queue.size();
            if (count > res) {
                res = count;
                resultLevel = level;
            }

            for (int i = 0; i < count; i++) {
                Node curr = queue.poll();
                if (curr.left != null) {
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }
            level++;
        }

        return resultLevel;
    }
}
