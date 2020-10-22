public class RotateList {
    public static ListNode rotate(ListNode head, int rotations) {

        int length = 0;
        ListNode curr = head;
        ListNode mark = null;
        ListNode last = null;
        while (curr != null) {
            last = curr;
            curr = curr.next;
            length++;
        }

        int shift  = length - (rotations%length);
        curr = head;
        while (shift > 0) {
            mark = curr;
            curr = curr.next;
            shift--;
        }
        mark.next = null;
        last.next = head;

        return curr;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        ListNode result = RotateList.rotate(head, 3);
        System.out.println("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
        System.out.println("");
        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        result = RotateList.rotate(head, 8);
        System.out.println("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }
}
