package challenge.jan.week1;
import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class RemoveDuplicatesFromSortedLists {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        while (curr != null) {
            boolean foundDups = false;
            while (curr != null && curr.next != null && curr.next.val == curr.val) {
                curr = curr.next;
                foundDups = true;
            }
            if (foundDups) {
                if (curr != null && curr.next != null) {
                    if (prev == null) {
                        head = curr.next;
                    } else {
                        prev.next = curr.next;
                    }
                    curr = curr.next;
                    continue;
                } else {
                    if (prev == null) {
                        return null;
                    } else {
                        prev.next = null;
                    }
                }
            }
            prev = curr;
            curr = curr.next;
        }

        return head;
    }
}
