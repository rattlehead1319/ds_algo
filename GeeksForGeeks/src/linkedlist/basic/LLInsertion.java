package linkedlist.basic;

public class LLInsertion {
    // Should insert a node at the beginning
    Node insertAtBeginning(Node head, int x)
    {
        Node newNode = new Node(x);
        newNode.next = head;
        head = newNode;
        return head;
    }

    // Should insert a node at the end
    Node insertAtEnd(Node head, int x)
    {
        Node newNode = new Node(x);
        if (head == null) {
            return newNode;
        }
        Node curr = head;
        while (curr != null && curr.next != null) {
            curr = curr.next;
        }
        curr.next = newNode;
        return head;
    }
}
