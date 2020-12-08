package linkedlist.basic;

public class InsertInMiddleOfLL {
    public Node insertInMid(Node head, int data){
        Node newNode = new Node(data);
        if (head == null) {
            return newNode;
        }
        Node slowPtr = head;
        Node fastPtr = head;
        Node prevSlow = null;
        int count = 0;
        Node curr = head;
        while (curr != null) {
            curr = curr.next;
            count++;
        }
        while (fastPtr != null && fastPtr.next != null) {
            prevSlow = slowPtr;
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        if (count%2 == 0) {
            prevSlow.next = newNode;
            newNode.next = slowPtr;
        } else {
            Node slowNext = slowPtr.next;
            slowPtr.next = newNode;
            newNode.next = slowNext;
        }
        return head;
    }
}
