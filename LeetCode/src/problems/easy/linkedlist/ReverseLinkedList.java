package problems.easy.linkedlist;

public class ReverseLinkedList {
    static class ListNode {
        int val;
        ListNode next;
    }

    public ListNode reverseList(ListNode head) {
        ListNode current = head;
        ListNode prev = null;
        while (current != null) {
            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        return prev;
    }
}
