package linkedlist.medium;

public class MergeSortOnDoublyLL {
    static class Node
    {
        int data;
        Node next, prev;
        Node(int data)
        {
            this.data = data;
            next = prev = null;
        }
    }
    static Node sortDoubly(Node head)
    {
        if (head == null || head.next == null) {
            return head;
        }

        Node middle = getMiddle(head);
        Node nextToMiddle = middle.next;
        middle.next = null;
        nextToMiddle.prev = null;

        Node left = sortDoubly(head);
        Node right = sortDoubly(nextToMiddle);
        Node sorted = sortedMerge(left, right);
        return sorted;
    }

    static Node getMiddle (Node curr) {
        Node slow = curr;
        Node fast = curr;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    static Node sortedMerge (Node a, Node b) {
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }

        Node result;
        if (a.data <= b.data) {
            result = a;
            Node x = sortedMerge(a.next, b);
            result.next = x;
            x.prev = result;
        } else {
            result = b;
            Node x = sortedMerge(a, b.next);
            result.next = x;
            x.prev = result;
        }
        return result;
    }
}
