package linkedlist.easy;

public class CheckIfPalindrome {
    boolean isPalindrome(Node head)
    {
        if (head == null) {
            return false;
        }
        if (head.next == null) {
            return true;
        }

        Node x = head;
        int n = getCount(x);
        int y = n%2 == 0 ? n/2 : n/2+1;
        Node curr = head;
        Node prev = null;
        while (y-- > 0) {
            prev = curr;
            curr = curr.next;
        }
        Node revLastHalf = reverse(curr);
        if (head == prev && head.data != revLastHalf.data) {
            return false;
        }
        while (head != prev.next && revLastHalf != null) {
            if (head.data != revLastHalf.data) {
                return false;
            }
            head = head.next;
            revLastHalf = revLastHalf.next;
        }
        return true;
    }

    int getCount(Node head) {
        int count = 0;
        while (head != null) {
            head = head.next;
            count++;
        }
        return count;
    }

    Node reverse (Node curr) {
        Node prev = null;
        while (curr != null) {
            Node temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}
