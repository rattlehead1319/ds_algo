package tree.problems.easy;

public class ChildrenSumParent {
    public static int isSumProperty(Node root)
    {
        if (root == null || (root.left == null && root.right == null))
        {
            return 1;
        }

        int left = 0;
        if (root.left != null) {
            left = root.left.data;
        }

        int right = 0;
        if (root.right != null) {
            right = root.right.data;
        }

        if (root.data == (left + right) &&
                isSumProperty(root.left) == 1 &&
                isSumProperty(root.right) == 1)
        {
            return 1;
        }

        return 0;
    }
}
