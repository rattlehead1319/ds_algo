package linkedlist.easy;

public class MergeSortForLL {
    static Node mergeSort(Node head)
    {
        if (head == null || head.next == null) {
            return head;
        }
        Node middle = getMiddle(head);
        Node nextToMiddle = middle.next;

        middle.next = null;
        Node left = mergeSort(head);
        Node right = mergeSort(nextToMiddle);
        Node sorted = sortedMerge(left, right);
        return sorted;
    }

    static Node getMiddle (Node curr) {
        Node slow = curr;
        Node fast = curr;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    static Node sortedMerge (Node a, Node b) {
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }

        Node result = null;
        if (a.data <= b.data) {
            result = a;
            result.next = sortedMerge(a.next, b);
        } else {
            result = b;
            result.next = sortedMerge(a, b.next);
        }
        return result;
    }
}
