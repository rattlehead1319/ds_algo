package ds.easy.linkedlist;

public class RemoveDuplicates {

    static class SinglyLinkedListNode {
        int data;
        SinglyLinkedListNode next;
        SinglyLinkedListNode(int data) {
            this.data = data;
        }
    }

    static SinglyLinkedListNode removeDuplicates(SinglyLinkedListNode head) {
        SinglyLinkedListNode current = head;
        SinglyLinkedListNode previous = null;

        while (current != null) {
            if (previous != null && previous.data == current.data) {
                current = current.next;
            } else {
                if (previous != null) {
                    previous.next = current;
                }
                previous = current;
                current = current.next;
            }
        }
        previous.next = null;
        return head;
    }
}
