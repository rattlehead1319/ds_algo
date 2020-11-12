package ds.easy.bst;

class Node {
    int data;
    Node left;
    Node right;
    Node (int data) {
        this.data= data;
    }
}
public class Insert {
    public static Node insert(Node root,int data) {
        if (root == null) {
            return new Node(data);
        }
        insertRec(root, data);
        return root;
    }

    private static void insertRec(Node root, int data) {
        if (root == null)  {
            return;
        }
        if (data > root.data) {
            if (root.right == null) {
                root.right = new Node(data);
                return;
            }
            insertRec(root.right, data);
        } else if (data < root.data) {
            if (root.left == null) {
                root.left = new Node(data);
                return;
            }
            insertRec(root.left, data);
        }
    }
}
