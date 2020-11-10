package tree.problems.medium;

/**
 * Tricky... good one
 */

public class FoldableTree {
    boolean IsFoldable(Node node)
    {
        if (node == null) {
            return true;
        }
        return IsFoldableRec(node.left, node.right);
    }

    boolean IsFoldableRec (Node n1, Node n2) {
        if (n1 == null && n2 == null) {
            return true;
        }
        if (n1 == null || n2 == null) {
            return false;
        }
        return IsFoldableRec(n1.left, n2.right) && IsFoldableRec(n1.right, n2.left);
    }
}
