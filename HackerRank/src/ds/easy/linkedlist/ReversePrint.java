package ds.easy.linkedlist;

public class ReversePrint {
    static class SinglyLinkedListNode {
        int data;
        SinglyLinkedListNode next;
        SinglyLinkedListNode(int data) {
            this.data = data;
        }
    }

    static void reversePrint(SinglyLinkedListNode head) {
        if (head == null) {
            return;
        } else if (head.next == null) {
            System.out.println(head.data);
            return;
        }
        SinglyLinkedListNode current = head;
        SinglyLinkedListNode previous = null;
        while (current != null) {
            SinglyLinkedListNode temp = current.next;
            current.next = previous;
            previous = current;
            current = temp;
        }
        current = previous;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }

    }
}
