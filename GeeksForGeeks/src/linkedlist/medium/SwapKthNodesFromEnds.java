package linkedlist.medium;

public class SwapKthNodesFromEnds {
    Node swapkthnode(Node head, int num, int K)
    {
        if (num < K) {
            return head;
        }

        if (2*K-1 == num) {
            return head;
        }

        int x = K;
        int rem = num - K;
        K--;

        Node first = head;
        Node prevFirst = null;
        while (first != null && K-- > 0) {
            prevFirst = first;
            first = first.next;
        }
        Node second = head;
        Node prevSecond = null;
        while (second != null && rem-- > 0) {
            prevSecond = second;
            second = second.next;
        }

        if (prevFirst != null) {
            prevFirst.next = second;
        }

        if (prevSecond != null) {
            prevSecond.next = first;
        }

        Node temp = first.next;
        first.next = second.next;
        second.next = temp;

        if (x == 1) {
            head = second;
        }

        if (x == num) {
            head = first;
        }

        return head;
    }
}
