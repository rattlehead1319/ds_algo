package problems.medium.linkedlist;

public class OddEven {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode odd = head;
        ListNode prevOdd = null;
        ListNode even = head.next;
        ListNode evenHead = even;
        while (odd != null) {
            odd.next = even != null ? even.next : null;
            prevOdd = odd;
            odd = odd.next;
            if (even != null) {
                even.next = odd != null ? odd.next : null;
                even = even.next;
            }
        }
        if (prevOdd != null) {
            prevOdd.next = evenHead;
        }
        return head;
    }
}
