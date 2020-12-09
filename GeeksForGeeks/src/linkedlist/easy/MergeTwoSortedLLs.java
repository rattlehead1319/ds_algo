package linkedlist.easy;

public class MergeTwoSortedLLs {
    Node sortedMerge(Node headA, Node headB) {
        // This is a "method-only" submission.
        // You only need to complete this method
        Node head = null;
        Node tail = null;
        if (headA.data < headB.data) {
            head = headA;
            tail = headA;
            headA = headA.next;
        } else {
            head = headB;
            tail = headB;
            headB = headB.next;
        }
        while (headA != null && headB != null) {
            if (headA.data < headB.data) {
                tail.next = headA;
                tail = headA;
                headA = headA.next;
            } else {
                tail.next = headB;
                tail = headB;
                headB = headB.next;
            }
        }
        if (headA != null) {
            tail.next = headA;
        }
        if (headB != null) {
            tail.next = headB;
        }
        return head;
    }
}
