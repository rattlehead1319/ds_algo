package linkedlist.easy;

public class AddTwoNumbersByLL {
    static Node addLists(Node first, Node second){

        if (first == null) {
            return second;
        }
        if (second == null) {
            return first;
        }
        // code here
        // return head of sum list
        Node x = reverse(first);
        Node y = reverse(second);

        int carry = 0;
        Node head = null;
        Node curr = null;
        while (x != null && y != null) {
            int val = x.data + y.data + carry;
            carry = val/10;
            val = val%10;
            if (head == null) {
                head = new Node(val);
                curr = head;
            } else {
                Node newNode = new Node(val);
                curr.next = newNode;
                curr = newNode;
            }
            x = x.next;
            y = y.next;
        }
        while (x != null) {
            int val = x.data + carry;
            carry = val/10;
            val = val%10;
            Node newNode = new Node(val);
            curr.next = newNode;
            curr = newNode;
            x = x.next;
        }
        while (y != null) {
            int val = y.data + carry;
            carry = val/10;
            val = val%10;
            Node newNode = new Node(val);
            curr.next = newNode;
            curr = newNode;
            y = y.next;
        }
        if (carry > 0) {
            curr.next = new Node(carry);
        }
        return reverse(head);
    }

    static Node reverse (Node head) {
        Node prev = null;
        while (head != null) {
            Node temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }
}
