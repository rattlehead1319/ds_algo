package tree.problems.easy;

//Must visit again.. this is when you recursively set children

public class RemoveHalfNodes {
    public static Node RemoveHalfNodes(Node root)
    {
        if (root == null) {
            return null;
        }

        return removeHalfNodesRec(root);
    }

    private static Node removeHalfNodesRec (Node root) {

        if (root == null) {
            return null;
        }

        root.left = removeHalfNodesRec(root.left);
        root.right = removeHalfNodesRec(root.right);

        if (root.left == null && root.right == null) {
            return root;
        }

        if (root.left == null) {
            return root.right;
        }

        if (root.right == null) {
            return root.left;
        }

        return root;
    }
}
