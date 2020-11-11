package tree.problems.medium;

public class CountSubTreesHavingSumX {
    class Result {
        int data;
    }
    int countSubtreesWithSumX(Node root, int X)
    {
        Result result = new Result();
        countSubtreesWithSumXRec(root, result, X);
        return result.data;
    }

    int countSubtreesWithSumXRec (Node root, Result result, int x) {
        if (root == null) {
            return 0;
        }

        int sum = root.data + countSubtreesWithSumXRec(root.left, result, x) +
                countSubtreesWithSumXRec(root.right, result, x);
        if (sum == x) {
            result.data++;
        }
        return sum;
    }
}
