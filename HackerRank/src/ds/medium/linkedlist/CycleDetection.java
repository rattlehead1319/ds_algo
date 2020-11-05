package ds.medium.linkedlist;

import ds.easy.linkedlist.RemoveDuplicates;

public class CycleDetection {

    static class SinglyLinkedListNode {
        int data;
        SinglyLinkedListNode next;
        SinglyLinkedListNode(int data) {
            this.data = data;
        }
    }

    static boolean hasCycle(SinglyLinkedListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        SinglyLinkedListNode slowPointer = head;
        SinglyLinkedListNode fastPointer = head.next;

        while (slowPointer != null && fastPointer != null && fastPointer.next != null) {
            if (slowPointer == fastPointer) {
                return true;
            }
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
        return false;
    }
}
