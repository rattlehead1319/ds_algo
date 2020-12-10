package linkedlist.medium;

public class IntersectionPointInYShapedLinks {
    int intersectPoint(Node head1, Node head2)
    {
        if (head1 == null || head2 == null) {
            return -1;
        }

        int m = 0;
        Node curr = head1;
        while (curr != null) {
            curr = curr.next;
            m++;
        }

        int n = 0;
        curr = head2;
        while (curr != null) {
            curr = curr.next;
            n++;
        }


        if (n > m) {
            int x = n-m;
            while (x-- > 0) {
                head2 = head2.next;
            }
        } else {
            int x = m-n;
            while (x-- > 0) {
                head1 = head1.next;
            }
        }

        while (head1 != null && head2 != null) {
            if (head1 == head2) {
                return head1.data;
            }
            head1 = head1.next;
            head2 = head2.next;
        }

        return -1;
    }
}
