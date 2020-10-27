import java.util.*;

class MinimumBinaryTreeDepth {
    public static int findDepth(TreeNode root) {
        if (root == null) {
            return -1;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int minDepth = 1;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i <levelSize; i++) {
                TreeNode currentNode = queue.poll();
                boolean hasAnyChild = false;
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                    hasAnyChild = true;
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                    hasAnyChild = true;
                }
                if (!hasAnyChild) {
                    return minDepth;
                }
            }
            minDepth++;
        }
        return -1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        System.out.println("Tree Minimum Depth: " + MinimumBinaryTreeDepth.findDepth(root));
        root.left.left = new TreeNode(9);
        root.right.left.left = new TreeNode(11);
        System.out.println("Tree Minimum Depth: " + MinimumBinaryTreeDepth.findDepth(root));
    }
}
