package linkedlist.basic;

class Node{
    int data;
    Node next;
    Node(int a){  data = a; next = null; }
}
public class CountNodesOfLL {
    public static int getCount(Node head)
    {
        int count = 0;
        while (head != null) {
            head = head.next;
            count++;
        }
        return count;
    }
}
