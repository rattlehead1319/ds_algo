package linkedlist.basic;

public class DoublyLLInsertionAtGivenPosition {
    static class Node
    {
        int data;
        Node next;
        Node prev;
        Node(int data)
        {
            this.data = data;
            next = prev = null;
        }
    }

    void addNode(Node head_ref, int pos, int data)
    {
        Node prev = null;
        while (pos-- > 0 && head_ref != null) {
            prev = head_ref;
            head_ref = head_ref.next;
        }
        Node newNode = new Node(data);
        if (head_ref == null) {
            prev.next = newNode;
            newNode.prev = prev;
        } else {
            Node headNext = head_ref.next;
            head_ref.next = newNode;
            newNode.prev = head_ref;
            newNode.next = headNext;
            if (headNext != null) {
                headNext.prev = newNode;
            }
        }
    }
}
