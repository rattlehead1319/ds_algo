package ds.easy.linkedlist;

public class GetNode {

    static class SinglyLinkedListNode {
        int data;
        SinglyLinkedListNode next;
        SinglyLinkedListNode(int data) {
            this.data = data;
        }
    }

    static int getNode(SinglyLinkedListNode head, int positionFromTail) {
        SinglyLinkedListNode current = head;
        int length = 0;
        while (current != null) {
            current = current.next;
            length++;
        }
        int positionFromFront = length - positionFromTail - 1;
        current = head;
        while (positionFromFront > 0) {
            current = current.next;
            positionFromFront--;
        }
        return current.data;

    }

}
