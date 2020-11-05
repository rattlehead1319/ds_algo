package ds.easy.linkedlist;

public class PrintLinkedList {
    class SinglyLinkedListNode {
        int data;
        SinglyLinkedListNode next;
    }

    static void printLinkedList(SinglyLinkedListNode head) {

        while (head != null) {
            System.out.println(head.data);
            head = head.next;
        }
    }
}
