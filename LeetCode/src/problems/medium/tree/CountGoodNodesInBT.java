package problems.medium.tree;

public class CountGoodNodesInBT {
    class Solution {
        private int result = 0;

        public int goodNodes(TreeNode root) {
            goodNodesRec(root, Integer.MIN_VALUE);
            return result;
        }

        private void goodNodesRec(TreeNode root, int max) {
            if (root == null) {
                return;
            }
            if (root.val >= max) {
                result++;
            }
            max = Math.max(max, root.val);
            goodNodesRec(root.left, max);
            goodNodesRec(root.right, max);
        }
    }
}
