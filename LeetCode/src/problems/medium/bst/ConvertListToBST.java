package problems.medium.bst;

import java.util.*;

public class ConvertListToBST {
    class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
    }

    private ListNode head;

    public TreeNode sortedListToBST(ListNode head) {
        this.head = head;
        int size = getSize(head);
        return createBST(0, size - 1);
    }

    private TreeNode createBST(int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode leftTree = createBST(left, mid - 1);

        TreeNode node = new TreeNode(head.val);
        node.left = leftTree;

        head = head.next;

        node.right = createBST(mid + 1, right);
        return node;
    }

    private int getSize(ListNode curr) {
        int c = 0;
        while (curr != null) {
            c++;
            curr = curr.next;
        }
        return c;
    }
}
