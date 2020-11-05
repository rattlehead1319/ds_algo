package ds.easy.linkedlist;

import ds.medium.linkedlist.CycleDetection;

/**
 * Little tricky, not much
 * https://www.hackerrank.com/challenges/find-the-merge-point-of-two-joined-linked-lists/problem
 */
public class FindMergeNode {
    static class SinglyLinkedListNode {
        int data;
        SinglyLinkedListNode next;
        SinglyLinkedListNode(int data) {
            this.data = data;
        }
    }

    static int findMergeNode(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {

        int list1Size = 0;
        SinglyLinkedListNode current = head1;
        while (current != null) {
            current = current.next;
            list1Size++;
        }
        int list2Size = 0;
        current = head2;
        while (current != null) {
            current = current.next;
            list2Size++;
        }
        int diff = 0;
        if (list1Size > list2Size) {
            diff = list1Size - list2Size;
            return getNode(diff, head1, head2);
        } else {
            diff = list2Size - list1Size;
            return getNode(diff, head2, head1);
        }
    }

    static int getNode (int diff, SinglyLinkedListNode current1, SinglyLinkedListNode current2) {
        while (diff > 0) {
            current1 = current1.next;
            diff--;
        }
        while (current1 != null && current2 != null) {
            if (current1 == current2) {
                return current1.data;
            }
            current1 = current1.next;
            current2 = current2.next;
        }
        return -1;
    }
}
