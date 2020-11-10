package tree.problems.medium;

public class BTtoCDLL {
    Node prev = null;
    Node bTreeToClist(Node root)
    {
        Node head = bTreeToClistRec(root);
        Node current = head;
        Node prev = null;
        while (current != null) {
            prev = current;
            current = current.right;
        }
        prev.right = head;
        head.left = prev;
        return head;
    }

    Node bTreeToClistRec(Node root) {
        if (root == null) {
            return null;
        }

        Node head = bTreeToClistRec(root.left);
        if (prev == null) {
            head = root;
        } else {
            prev.right = root;
            root.left = prev;
        }
        prev = root;
        bTreeToClistRec(root.right);

        return head;
    }
}
