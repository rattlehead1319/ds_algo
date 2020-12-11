package linkedlist.medium;

public class CLoneLLwithRandom {
    static class Node {
        int data;
        Node next, arb;

        Node(int d)
        {
            data = d;
            next = arb = null;

        }
    }

    Node copyList(Node head) {
        Node cloneHead = null;
        Node curr = head;
        while (curr != null) {
            Node temp = curr.next;
            Node x = new Node(curr.data);
            curr.next = x;
            x.next = temp;
            curr = temp;
        }


        curr = head;


        while (curr != null)
        {
            if(curr.next != null)  {
                curr.next.arb = (curr.arb != null) ? curr.arb.next : curr.arb;
            }

            curr = (curr.next != null) ? curr.next.next : curr.next;
        }

        curr = head;
        Node clonedHead = null;
        while (curr != null && curr.next != null) {
            Node temp = curr.next;
            curr.next = temp.next;
            curr = temp;
            if (clonedHead == null) {
                clonedHead = temp;
            }
        }

        return clonedHead;
    }
}
