package problems.medium.linkedlist;

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);

        int carry = 0;
        ListNode result = null;
        ListNode curr = null;
        while (l1 != null && l2 != null) {
            int val = l1.val + l2.val + carry;
            carry = val / 10;
            val = val % 10;
            ListNode newNode = new ListNode(val);
            if (result == null) {
                result = newNode;
                curr = newNode;
            } else {
                curr.next = newNode;
                curr = curr.next;
            }
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null && curr != null) {
            int val = l1.val + carry;
            carry = val / 10;
            val = val % 10;
            ListNode newNode = new ListNode(val);
            curr.next = newNode;
            curr = curr.next;
            l1 = l1.next;
        }

        while (l2 != null && curr != null) {
            int val = l2.val + carry;
            carry = val / 10;
            val = val % 10;
            ListNode newNode = new ListNode(val);
            curr.next = newNode;
            curr = curr.next;
            l2 = l2.next;
        }

        if (carry != 0) {
            curr.next = new ListNode(carry);
        }

        return reverse(result);
    }

    private ListNode reverse(ListNode curr) {
        ListNode prev = null;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
