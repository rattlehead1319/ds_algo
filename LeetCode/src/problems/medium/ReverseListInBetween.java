package problems.medium;

import problems.easy.ReverseLinkedList;

public class ReverseListInBetween {
    static class ListNode {
        int val;
        ListNode next;
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {

        if (head == null) {
            return null;
        }

        ListNode prevM = null;
        ListNode prev = null;
        ListNode current = head;

        m--;
        n--;
        while (m > 0) {
            prevM = current;
            current = current.next;
            m--;
            n--;
        }

        if (current == null) {
            return head;
        }

        ListNode tail = current;
        prev = prevM;

        while (n-- >= 0) {
            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }

        if (prevM != null) {
            prevM.next = prev;
        }
        if (tail != null) {
            tail.next = current;
        }

        if (prevM == null) {
            return prev;
        }

        return head;
    }
}
