package linkedlist.easy;

public class ReverseALL {
    Node reverseList(Node head)
    {
        if (head == null || head.next == null) {
            return head;
        }
        Node prev = null;
        while (head != null) {
            Node temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }
}
