package linkedlist.easy;

public class LengthOfLoop {
    static int countNodesinLoop(Node head)
    {
        if (head == null || head.next == null) {
            return 0;
        }
        Node slow = head.next;
        Node fast = head.next.next;

        while (fast != null && fast.next != null) {
            if (slow == fast) {
                break;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast == null || fast.next == null) {
            return 0;
        }

        slow = slow.next;
        int count = 1;
        while (slow != fast) {
            slow = slow.next;
            count++;
        }
        return count;
    }
}
