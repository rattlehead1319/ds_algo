package tree;

import java.util.*;

/**
 * Two stack approach is interesting
 */

public class TreeSpiralTraversal {
    static class Node {
        int data;
        Node left;
        Node right;
        Node (int data) {
            this.data = data;
        }
    }

    static void traverse (Node root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            System.out.println(root.data);
            return;
        }
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();

        stack1.push(root);
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                Node current = stack1.pop();
                if (current.left != null) {
                    stack2.push(current.left);
                }
                if (current.right != null) {
                    stack2.push(current.right);
                }
                System.out.print(current.data + " ");
            }
            System.out.println();
            while (!stack2.isEmpty()) {
                Node current = stack2.pop();
                if (current.right != null) {
                    stack1.push(current.right);
                }
                if (current.left != null) {
                    stack1.push(current.left);
                }
                System.out.print(current.data + " ");
            }
            System.out.println();
        }
    }

    public static void main (String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.left.left = new Node(8);
        root.left.left.right = new Node(9);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.left.left = new Node(10);
        root.right.left.right = new Node(11);
        traverse(root);
    }
}

