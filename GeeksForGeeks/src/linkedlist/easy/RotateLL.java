package linkedlist.easy;

public class RotateLL {
    public Node rotate(Node head, int k) {
        if (head == null) {
            return null;
        }

        Node x = head;
        int n = getCount(x);

        if (n == k) {
            return head;
        }

        k = k%n;
        k--;

        Node curr = head;
        while (k-- > 0 && curr != null) {
            curr = curr.next;
        }

        if (curr == null) {
            return head;
        }

        Node currNext = curr.next;
        curr.next = null;
        Node newHead = currNext;
        while (currNext != null && currNext.next != null) {
            currNext = currNext.next;
        }
        currNext.next = head;
        return newHead;
    }

    private int getCount (Node curr) {
        int count = 0;
        while (curr != null) {
            curr = curr.next;
            count++;
        }
        return count;
    }
}
