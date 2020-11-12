package bst.problems.easy;

public class LCA {
    Node LCA(Node root, int n1, int n2)
    {
        if (root == null) {
            return null;
        }

        if ((root.data == n1 || root.data == n2) ||
                (root.data > n1 && root.data < n2) ||
                (root.data < n1 && root.data > n2)
        )
        {
            return root;
        }
        if (root.data > n1 && root.data > n2) {
            return LCA(root.left, n1, n2);
        }
        if (root.data < n1 && root.data < n2) {
            return LCA(root.right, n1, n2);
        }
        return root;
    }
}
