package tree.problems.easy;

public class IsSumProperty {
    public static int isSumProperty(Node root)
    {
        if (root == null || (root.left == null && root.right == null)) {
            return 1;
        }
        int left = 0, right = 0;
        if (root.left != null) {
            left = root.left.data;
        }
        if (root.right != null) {
            right = root.right.data;
        }

        if (root.data == (left + right) &&
                isSumProperty(root.left) == 1 &&
                isSumProperty(root.right) ==1
        ) {
            return 1;
        }
        return 0;
    }
}
