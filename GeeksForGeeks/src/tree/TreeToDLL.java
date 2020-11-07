package tree;

/**
 * For linkedlist, traversal shall be inorder
 * Visit this again
 */

public class TreeToDLL {
    static class Node {
        int data;
        Node left;
        Node right;
        Node(int data) {
            this.data = data;
        }
    }

    static Node prev = null;
    static Node convertRec(Node root) {
        if (root == null) {
            return root;
        }
        Node head = convertRec(root.left);
        if (prev == null) {
            head = root;
        } else {
            prev.right = root;
            root.left = prev;
        }
        prev = root;
        convertRec(root.right);
        return head;
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.left.left = new Node(25);
        root.right = new Node(30);
        root.right.left = new Node(40);
        root.right.right = new Node(50);

        Node head = convertRec(root);
        while(head != null) {
            System.out.print(head.data + " ");
            head = head.right;
        }
    }
}
