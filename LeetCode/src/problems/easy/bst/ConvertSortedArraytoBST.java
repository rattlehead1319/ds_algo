package problems.easy.bst;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class ConvertSortedArraytoBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        return sortedArrayToBSTRec(nums, 0, nums.length - 1);
    }

    private TreeNode sortedArrayToBSTRec(int[] nums, int l, int r) {

        if (l > r) {
            return null;
        }

        int m = l + (r-l)/2;
        TreeNode root = new TreeNode(nums[m]);
        root.left = sortedArrayToBSTRec(nums, l, m-1);
        root.right = sortedArrayToBSTRec(nums, m+1, r);

        return root;
    }
}
