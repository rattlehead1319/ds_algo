package linkedlist.easy;

public class PairwiseSwapOfLL {
    public static Node pairwise_swap(Node node)
    {
        if (node == null || node.next == null) {
            return node;
        }
        Node prev = node;
        node = node.next;
        Node head = node;
        Node temp = node.next;
        node.next = prev;
        prev.next = pairwise_swap(temp);
        return head;
    }
}
