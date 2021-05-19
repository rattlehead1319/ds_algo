package tree.problems.easy;

public class HeightOfSpiralTree {
    public static int findTreeHeight(Node root)
    {
        if (root == null) {
            return 0;
        }

        if ((root.left != null && root.left.right == root) ||
                (root.right != null && root.right.left == root))
        {
            return 1;
        }

        return 1 + Math.max(findTreeHeight(root.left), findTreeHeight(root.right));
    }
}
