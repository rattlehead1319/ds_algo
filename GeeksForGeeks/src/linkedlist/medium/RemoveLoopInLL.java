package linkedlist.medium;

public class RemoveLoopInLL {
    public static void removeLoop(Node head){
        // code here
        // remove the loop without losing any nodes
        if (head == null || head.next == null) {
            return;
        }
        Node slow = head.next;
        Node fast = head.next.next;

        Node prev = null;
        while (fast != null && fast.next != null) {
            if (slow == fast) {
                break;
            }
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast == null || fast.next == null) {
            return;
        }

        slow = head;
        while (slow != fast) {
            prev = fast;
            fast = fast.next;
            slow = slow.next;
        }

        prev.next = null;
    }
}
