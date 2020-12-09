package linkedlist.easy;

public class DetectLoop {
    public static boolean detectLoop(Node head){
        if (head == null || head.next == null) {
            return false;
        }

        if (head.next == head) {
            return true;
        }

        Node slow = head.next;
        Node fast = head.next.next;

        while (fast != null && fast.next != null) {
            if (slow == fast) {
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }
}
