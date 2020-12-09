package linkedlist.easy;

public class NthNodeFromEndOfLL {
    int getNthFromLast(Node head, int n)
    {
        Node curr = head;
        int k = n;
        while (curr != null && k-- > 0) {
            curr = curr.next;
        }
        if (k > 0 && curr == null) {
            return -1;
        }
        Node secCurr = head;
        while (curr != null) {
            secCurr = secCurr.next;
            curr = curr.next;
        }
        return secCurr.data;
    }
}
