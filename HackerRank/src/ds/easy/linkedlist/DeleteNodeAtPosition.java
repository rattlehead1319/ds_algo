package ds.easy.linkedlist;

public class DeleteNodeAtPosition {

    static class SinglyLinkedListNode {
        int data;
        SinglyLinkedListNode next;
        SinglyLinkedListNode(int data) {
            this.data = data;
        }
    }

    static SinglyLinkedListNode delete(SinglyLinkedListNode head, int position) {
        if (position == 0) {
            SinglyLinkedListNode nextHead = head.next;
            head.next = null;
            return nextHead;
        } else {
            SinglyLinkedListNode current = head;
            int index = 0;
            while (index < position - 1) {
                current = current.next;
                index++;
            }
            SinglyLinkedListNode nodeToBeDeleted = current.next;
            current.next = nodeToBeDeleted.next;
            nodeToBeDeleted.next = null;
        }
        return head;
    }

}
