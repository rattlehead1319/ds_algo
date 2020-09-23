public class PalindromicLinkedList {
    public static boolean isPalindrome(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (slow.next != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode mid = reverse(slow);
        ListNode midCopy = mid;

        while (head != null && mid != null) {
            if (head.value != mid.value) {
                break;
            }
            head = head.next;
            mid = mid.next;
        }

        reverse(midCopy);

        if (head == null || mid == null) {
            return true;
        }
        return false;
    }

    private static ListNode reverse(ListNode current)  {
        ListNode prev = null;
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(2);
        System.out.println("Is palindrome: " + PalindromicLinkedList.isPalindrome(head));

        head.next.next.next.next.next = new ListNode(2);
        System.out.println("Is palindrome: " + PalindromicLinkedList.isPalindrome(head));
    }
}
