package tree.problems.easy;

public class MirrorTree {
    void mirror(Node node)
    {
        mirrorRec(node);
    }

    Node mirrorRec(Node node) {
        if (node == null) {
            return null;
        }
        Node left = mirrorRec(node.left);
        Node right = mirrorRec(node.right);
        node.left = right;
        node.right = left;
        return node;
    }
}
