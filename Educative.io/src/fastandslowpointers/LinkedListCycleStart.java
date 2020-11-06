package fastandslowpointers;

class LinkedListCycleStart {

    public static ListNode findCycleStart(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        //Get the pointers meet
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }

        //Find the length of circle
        ListNode slow1 = slow;
        int circleLength = 0;
        while (slow1 != null) {
            slow1 = slow1.next;
            circleLength++;
            if (slow1 == slow){
                break;
            }
        }

        ListNode slow3 = head;
        ListNode slow4 = head;

        //Give headstart to slow4 by circleLength
        for (int i = 0; i < circleLength; i++) {
            slow3 = slow3.next;
        }

        while (slow3 != slow4) {
            slow3 = slow3.next;
            slow4 = slow4.next;
        }

        return slow3;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        head.next.next.next.next.next.next = head.next.next;
        System.out.println("LinkedList cycle start: " + LinkedListCycleStart.findCycleStart(head).value);

        head.next.next.next.next.next.next = head.next.next.next;
        System.out.println("LinkedList cycle start: " + LinkedListCycleStart.findCycleStart(head).value);

        head.next.next.next.next.next.next = head;
        System.out.println("LinkedList cycle start: " + LinkedListCycleStart.findCycleStart(head).value);
    }
}