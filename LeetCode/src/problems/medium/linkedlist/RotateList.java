package problems.medium.linkedlist;

public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        ListNode curr = head;
        int length = getLength(curr);
        k = k % length;

        if (k == 0) {
            return head;
        }

        ListNode ptr1 = head;
        while (k-- > 0) {
            ptr1 = ptr1.next;
        }

        ListNode ptr2 = head;
        ListNode prev1 = null;
        ListNode prev2 = null;
        while (ptr1 != null) {
            prev2 = ptr2;
            ptr2 = ptr2.next;
            prev1 = ptr1;
            ptr1 = ptr1.next;
        }

        if (prev2 != null) {
            prev2.next = null;
        }

        prev1.next = head;
        return ptr2;
    }

    private int getLength(ListNode curr) {
        int count = 0;
        while (curr != null) {
            count++;
            curr = curr.next;
        }
        return count;
    }
}
