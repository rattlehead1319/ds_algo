package ds.easy.linkedlist;

public class InsertNodeAtPosition {
    static class SinglyLinkedListNode {
        int data;
        SinglyLinkedListNode next;
        SinglyLinkedListNode(int data) {
            this.data = data;
        }
    }

    static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode head, int data, int position) {
        SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
        if (position == 0) {
            newNode.next = head;
            return newNode;
        }
        int index = 0;
        SinglyLinkedListNode current = head;
        while (index < position - 1) {
            current = current.next;
            index++;
        }
        SinglyLinkedListNode temp = current.next;
        current.next = newNode;
        newNode.next = temp;
        return head;
    }
}
