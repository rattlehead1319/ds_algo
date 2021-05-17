package challenge.jan.week2;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class AddTwoNumbersLinkedList {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode head = null;
        ListNode curr = null;

        while (l1 != null && l2 != null) {
            int val = (l1.val + l2.val + carry) % 10;
            ListNode newNode= new ListNode(val);
            if (head == null) {
                head = newNode;
                curr = head;
            } else {
                curr.next = newNode;
            }
            curr = newNode;
            carry = (l1.val + l2.val + carry) / 10;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            ListNode newNode= new ListNode((l1.val + carry) % 10);
            carry = (l1.val + carry) / 10;
            curr.next = newNode;
            curr = newNode;
            l1 = l1.next;
        }

        while (l2 != null) {
            ListNode newNode= new ListNode((l2.val + carry) % 10);
            carry = (l2.val + carry) / 10;
            curr.next = newNode;
            curr = newNode;
            l2 = l2.next;
        }

        if (carry != 0) {
            curr.next = new ListNode(carry);
        }

        return head;
    }
}
