package ds.easy.linkedlist;

public class DoublyLinkedList {
    static class DoublyLinkedListNode {
        int data;
        DoublyLinkedListNode next;
        DoublyLinkedListNode prev;

        DoublyLinkedListNode(int data) {
            this.data = data;
        }
    }
    static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode head, int data) {
        DoublyLinkedListNode newNode = new DoublyLinkedListNode(data);
        if (data < head.data) {
            newNode.next = head;
            head.prev = newNode;
            return newNode;
        }
        DoublyLinkedListNode current = head;
        DoublyLinkedListNode previous = null;
        while (current != null && current.data < data) {
            previous = current;
            current = current.next;
        }

        DoublyLinkedListNode temp = previous.next;

        previous.next = newNode;
        newNode.prev = previous;

        if (temp != null) {
            newNode.next = temp;
            temp.prev = newNode;
        }

        return head;
    }
}
