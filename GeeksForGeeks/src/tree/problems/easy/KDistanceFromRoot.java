package tree.problems.easy;

import java.util.*;

public class KDistanceFromRoot {
    ArrayList<Integer> Kdistance(Node root, int k)
    {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        int level = 0;
        while (!queue.isEmpty()) {
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                Node curr = queue.poll();
                if (level == k) {
                    result.add(curr.data);
                }

                if (curr.left != null) {
                    queue.add(curr.left);
                }

                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }
            if (!result.isEmpty()) {
                return result;
            }
            level++;
        }

        return result;
    }
}
