package problems.medium.bst;

public class KthSmallestElementInBST {
    private int result = 0;
    private int count = 0;

    public int kthSmallest(TreeNode root, int k) {

        inOrder(root, k);
        return result;
    }

    private void inOrder(TreeNode root, int k) {
        if (root == null) {
            return;
        }

        inOrder(root.left, k);
        count++;
        if (count == k) {
            result = root.val;
            return;
        } else if (count > k) {
            return;
        }

        inOrder(root.right, k);
    }
}
