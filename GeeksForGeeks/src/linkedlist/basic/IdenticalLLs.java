package linkedlist.basic;

public class IdenticalLLs {
    public boolean isIdentical (Node head1, Node head2){
        //write your code here and return true if they are identical, otherwise false
        if ((head1 == null && head2 != null) || (head1 != null && head2 == null)) {
            return false;
        }
        while (head1 != null && head2 != null) {
            if (head1.data != head2.data) {
                return false;
            }
            head1 = head1.next;
            head2 = head2.next;
        }
        if (head1 != null || head2 != null) {
            return false;
        }
        return true;
    }
}
