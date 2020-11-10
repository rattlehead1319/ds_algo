package tree.problems.medium;

public class TreefromInOrderAndPostOrder {
    int postIndex = 0;

    Node buildTree(int in[], int post[], int n) {
        if (n == 0) {
            return null;
        }
        postIndex = n-1;
        return buildTreeRec(in, post, 0, n - 1);
    }

    Node buildTreeRec(int in[], int post[], int start, int end) {
        if (start > end) {
            return null;
        }
        Node root = new Node(post[postIndex--]);
        int inIndex = 0;
        for (int i = start; i <= end; i++) {
            if (in[i] == root.data) {
                inIndex = i;
                break;
            }
        }
        root.right = buildTreeRec(in, post, inIndex + 1, end);
        root.left = buildTreeRec(in, post, start, inIndex - 1);
        return root;
    }
}
