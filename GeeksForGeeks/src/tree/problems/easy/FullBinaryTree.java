package tree.problems.easy;

public class FullBinaryTree {
    boolean isFullTree(Node node)
    {
        if (node != null && node.left == null && node.right != null) {
            return false;
        }
        if (node != null && node.right == null && node.left != null) {
            return false;
        }
        if (node == null) {
            return true;
        }
        if (!isFullTree(node.left)) {
            return false;
        }
        return isFullTree(node.right);
    }
}
