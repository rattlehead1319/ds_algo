package tree.tutorials;

import java.util.*;

public class SerializeDeserialize {
    static class Node {
        int data;
        Node left;
        Node right;
        Node (int data) {
            this.data = data;
        }
    }

    public void serialize(Node root, ArrayList<Integer> A) {
        if (root == null) {
            A.add(-1);
            return;
        }
        A.add(root.data);
        serialize(root.left, A);
        serialize(root.right, A);
    }
    int index = 0;
    public Node deSerialize(ArrayList<Integer> A){
        if (index == A.size()) {
            return null;
        }
        int val = A.get(index++);
        if (val == -1) {
            return null;
        }

        Node root = new Node(val);
        root.left = deSerialize(A);
        root.right = deSerialize(A);
        return root;
    }
}
