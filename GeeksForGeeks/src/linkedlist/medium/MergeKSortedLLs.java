package linkedlist.medium;

public class MergeKSortedLLs {
    Node mergeKList(Node[]a,int N)
    {
        return mergeKListRec(a, 0, N-1);
    }

    Node mergeKListRec(Node[]a, int start, int end) {
        if (start == end) {
            return a[start];
        }

        int middle = (end+start)/2;
        Node left = mergeKListRec(a, start, middle);
        Node right = mergeKListRec(a, middle+1, end);

        Node head = null;
        Node tail = null;
        while (left != null && right != null) {
            if (left.data <= right.data) {
                if (head == null) {
                    head = left;
                }
                if (tail != null) {
                    tail.next = left;
                }
                tail = left;
                left = left.next;
            } else {
                if (head == null) {
                    head = right;
                }
                if (tail != null) {
                    tail.next = right;
                }
                tail = right;
                right = right.next;
            }
        }
        while (left != null) {
            tail.next = left;
            tail = left;
            left = left.next;
        }
        while (right != null) {
            tail.next = right;
            tail = right;
            right = right.next;
        }

        return head;
    }
}
