import java.util.*;

class ReverseSubList {

    public static ListNode reverse(ListNode head, int p, int q) {
        ListNode firstLinkBreak = null;
        ListNode curr = head;
        while (curr.value != p) {
            firstLinkBreak = curr;
            curr = curr.next;
        }
        ListNode prev = null;
        ListNode tail = curr;
        while (curr.value != q) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        ListNode secondLinkBreak = curr.next;
        curr.next = prev;
        firstLinkBreak.next = curr;
        tail.next = secondLinkBreak;

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode result = ReverseSubList.reverse(head, 2, 4);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }
}