package bst.problems.basic;

public class MinValue {
    int minValue(Node node)
    {
        if (node == null) {
            return -1;
        }
        if (node.left == null) {
            return node.data;
        }
        return minValue(node.left);
    }
}
