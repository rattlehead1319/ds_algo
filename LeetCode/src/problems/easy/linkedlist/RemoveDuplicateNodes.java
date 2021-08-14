package problems.easy.linkedlist;

public class RemoveDuplicateNodes {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;
        ListNode fast = curr;
        while (curr != null) {
            while (fast != null && fast.val == curr.val) {
                fast = fast.next;
            }
            curr.next = fast;
            curr = fast;
        }
        return head;
    }
}
