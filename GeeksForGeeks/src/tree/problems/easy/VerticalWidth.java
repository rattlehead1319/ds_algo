package tree.problems.easy;

public class VerticalWidth {
    static int min = 0, max = 0;
    public static int verticalWidth(Node root)
    {
        if (root == null) {
            return 0;
        }
        min = 0;
        max = 0;
        verticalWidthRec(root, 0);
        return max - min + 1;
    }

    private static void verticalWidthRec(Node root, int curr) {
        if (root == null) {
            return;
        }

        verticalWidthRec(root.left, curr - 1);
        min = Math.min(min, curr);
        max = Math.max(max, curr);
        verticalWidthRec(root.right, curr + 1);
    }
}
