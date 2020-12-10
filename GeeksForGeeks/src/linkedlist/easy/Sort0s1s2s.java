package linkedlist.easy;

public class Sort0s1s2s {
    static Node segregate(Node head)
    {
        if (head == null || head.next == null) {
            return head;
        }

        Node zero = null;
        Node one = null;
        Node two = null;

        Node zeroH = null;
        Node oneH = null;
        Node twoH = null;

        Node curr = head;
        while (curr != null) {
            if (curr.data == 0) {
                if (zero == null) {
                    zeroH = curr;
                } else {
                    zero.next = curr;
                }
                zero = curr;
            } else if (curr.data == 1) {
                if (one == null) {
                    oneH = curr;
                } else {
                    one.next = curr;
                }
                one = curr;
            } else if (curr.data == 2) {
                if (two == null) {
                    twoH = curr;
                } else {
                    two.next = curr;
                }
                two = curr;
            }
            curr = curr.next;
        }
        zero.next = oneH != null ? oneH : twoH;
        if (one != null) {
            one.next = twoH;
        }
        if (two != null) {
            two.next = null;
        }
        return zeroH;
    }
}
