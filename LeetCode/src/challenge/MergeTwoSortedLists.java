package challenge;

public class MergeTwoSortedLists {
    static class ListNode {
        int val;
        ListNode next;
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode current = null;
        ListNode result = null;

        while (l1 != null && l2 != null) {
            ListNode temp1 = l1.next;
            ListNode temp2 = l2.next;
            if (l1.val < l2.val) {
                if (current == null) {
                    current = l1;
                    result = current;
                } else {
                    current.next = l1;
                    current = current.next;
                }
                l1 = temp1;
            } else if (l1.val > l2.val) {
                if (current == null) {
                    current = l2;
                    result = current;
                } else {
                    current.next = l2;
                    current = current.next;
                }
                l2 = temp2;
            } else {
                if (current == null) {
                    current = l1;
                    result = current;
                } else {
                    current.next = l1;
                    current = current.next;
                }
                current.next = l2;
                current = current.next;

                l1 = temp1;
                l2 = temp2;
            }
        }

        while (l1 != null) {
            current.next = l1;
            current = current.next;
            l1 = l1.next;
        }

        while (l2 != null) {
            current.next = l2;
            current = current.next;
            l2 = l2.next;
        }

        return result;
    }
}
