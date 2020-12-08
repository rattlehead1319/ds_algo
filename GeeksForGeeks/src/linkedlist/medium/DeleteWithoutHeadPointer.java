package linkedlist.medium;

class Node
{
    int data ;
    Node next;
    Node(int d)
    {
        data = d;
        next = null;
    }
}

public class DeleteWithoutHeadPointer {
    void deleteNode(Node node)
    {
        Node nodeNext = node.next;
        node.data = nodeNext.data;
        node.next = nodeNext.next;
        nodeNext.next = null;
    }
}
