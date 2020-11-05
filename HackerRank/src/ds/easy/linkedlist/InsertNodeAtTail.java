package ds.easy.linkedlist;

public class InsertNodeAtTail {
    static class SinglyLinkedListNode {
        int data;
        SinglyLinkedListNode next;
        SinglyLinkedListNode(int data) {
            this.data = data;
        }
    }
    static SinglyLinkedListNode insertNodeAtTail(SinglyLinkedListNode head, int data) {

        SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
        newNode.next = null;

        if (head == null) {
            head = newNode;
        } else {
            SinglyLinkedListNode current = head;
            SinglyLinkedListNode previous = null;
            while (current != null) {
                previous = current;
                current = current.next;
            }
            previous.next = newNode;
        }

        return head;
    }
}
