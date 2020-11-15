package bst.problems.medium;

public class CountBSTNodesInRange {
    public static class Result {
        int data = 0;
    }

    public static int getCountOfNode(Node root,int l, int h)
    {
        if (root == null) {
            return 0;
        }
        Result result = new Result();
        getCountOfNodeRec(root, l, h, result);
        return result.data;
    }

    private static void getCountOfNodeRec(Node root, int l, int h, Result result) {
        if (root == null) {
            return;
        }
        getCountOfNodeRec(root.left, l, h, result);
        if (root.data >= l && root.data <= h) {
            result.data++;
        }
        getCountOfNodeRec(root.right, l , h, result);
    }
}
