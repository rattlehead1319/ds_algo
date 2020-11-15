package bst.problems.medium;

import java.util.*;

/**
 * Very nice. Visit again
 */

public class PreOrderToPostOrder {
    public static Node constructTree(int pre[], int size) {
        if (pre.length == 0) {
            return null;
        }
        Stack<Node> stack = new Stack<>();
        Node root = new Node(pre[0]);
        stack.push(root);

        for (int index = 1; index < size; index++) {
            int value = pre[index];
            Node current = new Node(value);
            Node temp = null;
            while (!stack.isEmpty() && pre[index] > stack.peek().data) {
                temp = stack.pop();
            }
            if (temp != null) {
                temp.right = current;
            } else {
                stack.peek().left = current;
            }
            stack.push(current);
        }

        return root;
    }
}
