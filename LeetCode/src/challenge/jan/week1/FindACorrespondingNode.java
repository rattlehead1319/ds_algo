package challenge.jan.week1;

import java.util.*;

public class FindACorrespondingNode {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {

        Queue<TreeNode> originalQ = new LinkedList<>();
        Queue<TreeNode> clonedQ = new LinkedList<>();

        originalQ.add(original);
        clonedQ.add(cloned);

        while (!originalQ.isEmpty()) {
            int count = originalQ.size();
            for (int i = 0; i < count; i++) {
                TreeNode curr = originalQ.poll();
                if (curr.val == target.val) {
                    return clonedQ.poll();
                }
                TreeNode clonedCurr = clonedQ.poll();
                if (curr.left != null) {
                    originalQ.offer(curr.left);
                    clonedQ.offer(clonedCurr.left);
                }
                if (curr.right != null) {
                    originalQ.offer(curr.right);
                    clonedQ.offer(clonedCurr.right);
                }
            }
        }

        return null;
    }
}
