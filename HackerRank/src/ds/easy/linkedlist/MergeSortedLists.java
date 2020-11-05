package ds.easy.linkedlist;

public class MergeSortedLists {

    static class SinglyLinkedListNode {
        int data;
        SinglyLinkedListNode next;
        SinglyLinkedListNode(int data) {
            this.data = data;
        }
    }

    static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        SinglyLinkedListNode head = null;
        SinglyLinkedListNode current = null;
        while (head1 != null && head2 != null) {
            if (head1.data < head2.data) {
                if (head == null) {
                    head = new SinglyLinkedListNode(head1.data);
                    current = head;
                } else {
                    current.next = new SinglyLinkedListNode(head1.data);
                    current = current.next;
                }
                head1 = head1.next;
            } else {
                if (head == null) {
                    head = new SinglyLinkedListNode(head2.data);
                    current = head;
                } else {
                    current.next = new SinglyLinkedListNode(head2.data);
                    current = current.next;
                }
                head2 = head2.next;
            }
        }
        while (head1 != null) {
            current.next = new SinglyLinkedListNode(head1.data);
            current = current.next;
            head1 = head1.next;
        }
        while (head2 != null) {
            current.next = new SinglyLinkedListNode(head2.data);
            current = current.next;
            head2 = head2.next;
        }
        return head;
    }
}
