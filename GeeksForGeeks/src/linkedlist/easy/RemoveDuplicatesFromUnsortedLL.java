package linkedlist.easy;

import java.util.*;

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

public class RemoveDuplicatesFromUnsortedLL {
    public Node removeDuplicates(Node head)
    {
        Set<Integer> set = new HashSet<>();
        Node curr = head;
        Node prev = null;
        while (curr != null) {
            if (!set.contains(curr.data)) {
                set.add(curr.data);
                prev = curr;
            } else {
                prev.next = curr.next;
            }
            curr = curr.next;
        }
        return head;
    }
}
