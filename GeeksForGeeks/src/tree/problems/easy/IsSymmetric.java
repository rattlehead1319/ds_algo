package tree.problems.easy;

public class IsSymmetric {
    public static boolean isSymmetric(Node root)
    {
        if (root == null) {
            return true;
        }

        return isSymmetricRec(root.left, root.right);
    }

    private static boolean isSymmetricRec (Node left, Node right) {
        if (left == null && right == null) {
            return true;
        }

        if (left == null && right != null) {
            return false;
        }

        if (left != null && right == null) {
            return false;
        }

        return (left.data == right.data &&
                isSymmetricRec(left.left, right.right) &&
                isSymmetricRec(left.right, right.left));
    }
}
