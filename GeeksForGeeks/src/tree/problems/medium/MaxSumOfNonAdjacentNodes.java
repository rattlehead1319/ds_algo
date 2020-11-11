package tree.problems.medium;

/***
 * Visit again, got to be better solution than this
 */
public class MaxSumOfNonAdjacentNodes {
    static class Pair {
        int first,second;
        Pair(int first,int second) {
            this.first = first;
            this.second = second;
        }
    }
    static int maxSum = 0;
    static int getMaxSum(Node root)
    {
        Pair res=maxSumHelper(root);
        return Math.max(res.first, res.second);
    }

    static Pair maxSumHelper(Node root) {
        Pair sum;
        if (root == null)
        {
            sum=new Pair(0, 0);
            return sum;
        }
        Pair sum1 = maxSumHelper(root.left);
        Pair sum2 = maxSumHelper(root.right);
        Pair sum3 = new Pair(0,0);

        // This node is included (Left and
        // right children are not included)
        sum3.first = sum1.second + sum2.second + root.data;

        // This node is excluded (Either left
        // or right child is included)
        sum3.second = Math.max(sum1.first, sum1.second) +
                Math.max(sum2.first, sum2.second);

        return sum3;
    }
}
