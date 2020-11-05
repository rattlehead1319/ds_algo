package ds.easy.linkedlist;

public class ReverseList {
    static class SinglyLinkedListNode {
        int data;
        SinglyLinkedListNode next;
        SinglyLinkedListNode(int data) {
            this.data = data;
        }
    }

    static SinglyLinkedListNode reverse(SinglyLinkedListNode head) {

        SinglyLinkedListNode current = head;
        SinglyLinkedListNode previous = null;
        while (current != null) {
            SinglyLinkedListNode temp = current.next;
            current.next = previous;
            previous = current;
            current = temp;
        }
        return previous;
    }
}
