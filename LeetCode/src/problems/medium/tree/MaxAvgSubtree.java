package problems.medium.tree;

public class MaxAvgSubtree {
    double maxAverage = Double.MIN_VALUE;

    public double maximumAverageSubtree(TreeNode root) {
        maximumAverageSubtreeRec(root); //mysolution
        return maxAverage;
        // return maxAverage(root).maxAverage;
    }

    private int maximumAverageSubtreeRec(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftSum = maximumAverageSubtreeRec(root.left);
        int rightSum = maximumAverageSubtreeRec(root.right);

        int val = root.val;
        int sum = leftSum + rightSum + val;

        int leftNodeCount = root.left == null ? 0 : root.left.val;
        int rightNodeCount = root.right == null ? 0 : root.right.val;
        int nodeCount = 1 + leftNodeCount + rightNodeCount;
        root.val = nodeCount;

        double avg = (double)sum/(double)nodeCount;
        maxAverage = Math.max(avg, maxAverage);

        return sum;
    }

    State maxAverage(TreeNode root) {
        if (root == null) {
            return new State(0, 0, 0);
        }

        // postorder traversal, solve for both child nodes first.
        State left = maxAverage(root.left);
        State right = maxAverage(root.right);

        // now find nodeCount, valueSum and maxAverage for current node `root`
        int nodeCount = left.nodeCount + right.nodeCount + 1;
        int sum = left.valueSum + right.valueSum + root.val;
        double maxAverage = Math.max(
                (1.0 * (sum)) / nodeCount, // average for current node
                Math.max(right.maxAverage, left.maxAverage) // max average from child nodes
        );

        return new State(nodeCount, sum, maxAverage);
    }

    class State {
        // count of nodes in the subtree
        int nodeCount;

        // sum of values in the subtree
        int valueSum;

        // max average found in the subtree
        double maxAverage;

        State(int nodes, int sum, double maxAverage) {
            this.nodeCount = nodes;
            this.valueSum = sum;
            this.maxAverage = maxAverage;
        }
    }
}
