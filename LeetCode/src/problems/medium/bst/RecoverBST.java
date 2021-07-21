package problems.medium.bst;

public class RecoverBST {
    private TreeNode first;
    private TreeNode second;
    private TreeNode prev;

    public void recoverTree(TreeNode root) {
        inOrder(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        inOrder(root.left);

        if (prev != null && prev.val > root.val) {
            if (first != null) {
                second = root;
            } else {
                first = prev;
                second = root;
            }
        }

        prev = root;
        inOrder(root.right);
    }
}
