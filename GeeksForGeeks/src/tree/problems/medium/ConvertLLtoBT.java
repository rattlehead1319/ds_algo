package tree.problems.medium;

import java.util.*;

public class ConvertLLtoBT {
    static class Tree{
        int data;
        Tree left;
        Tree right;
        Tree(int d){
            data=d;
            left=null;
            right=null;
        }
    }

    static class Node {
        int data;
        Node next;
        Node(int d) {
            data = d;
            next = null;
        }
    }

    public static Tree convert(Node head, Tree node) {
        if (head == null) {
            return null;
        }

        Tree root = new Tree(head.data);
        Queue<Tree> queue = new LinkedList<Tree>();
        queue.add(root);
        head = head.next;

        while (head != null) {
            Tree current = queue.poll();
            Tree leftChild = new Tree(head.data);
            queue.add(leftChild);

            head = head.next;
            Tree rightChild = null;
            if (head != null) {
                rightChild = new Tree(head.data);
                queue.add(rightChild);
                head = head.next;
            }
            current.left = leftChild;
            current.right = rightChild;
        }
        return root;
    }
}
