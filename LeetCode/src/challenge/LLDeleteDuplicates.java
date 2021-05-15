import java.util.*;

public class LLDeleteDuplicates {
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
