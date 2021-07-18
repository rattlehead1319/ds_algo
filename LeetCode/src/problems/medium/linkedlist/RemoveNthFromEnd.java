package problems.medium.linkedlist;

public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }

        ListNode ptr1 = head;
        while (ptr1 != null && n-- > 0) {
            ptr1 = ptr1.next;
        }

        if (ptr1 == null) {
            return head.next;
        }

        ListNode ptr2 = head;
        ListNode prevPtr2 = null;
        while (ptr1 != null) {
            ptr1 = ptr1.next;
            prevPtr2 = ptr2;
            ptr2 = ptr2.next;
        }
        if (prevPtr2 != null) {
            prevPtr2.next = ptr2.next;
        }
        ptr2.next = null;
        return head;
    }
}
