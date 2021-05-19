package tree.problems.easy;

class Helper2 {
    int sum;
}

public class SumOfLeftLeafNodes {
    public int leftLeavesSum(Node root)
    {
        if (root == null) {
            return 0;
        }

        Helper2 h = new Helper2();
        leftLeavesSumRec(root, h);
        return h.sum;
    }

    private void leftLeavesSumRec(Node root, Helper2 h) {
        if (root == null) {
            return;
        }
        if (root.left != null && root.left.left == null && root.left.right == null) {
            h.sum += root.left.data;
        }
        leftLeavesSumRec(root.left, h);
        leftLeavesSumRec(root.right, h);
    }
}
