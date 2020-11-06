package linkedlistreversal;

class ReverseEveryAlternateKElements {

    public static ListNode reverse(ListNode head, int k) {

        ListNode curr = head;
        ListNode prev = null;
        ListNode subPrev = null;
        boolean doReverse = true;
        while (curr != null) {
            int i = 0;
            ListNode tail = curr;
            while (doReverse && i < k && curr != null) {
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
                i++;
            }
            while (!doReverse && i < k && curr != null) {
                prev = curr;
                curr = curr.next;
                i++;
            }
            if (subPrev != null) {
                if (doReverse) {
                    subPrev.next = prev;
                }
            } else {
                head = prev;
            }
            if (doReverse) {
                tail.next = curr;
                subPrev = tail;
            } else {
                subPrev = prev;
            }

            doReverse = !doReverse;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);

        ListNode result = ReverseEveryAlternateKElements.reverse(head, 2);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }
}