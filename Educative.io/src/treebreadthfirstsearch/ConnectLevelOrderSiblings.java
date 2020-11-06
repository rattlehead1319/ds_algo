package treebreadthfirstsearch;

import java.util.*;

class TreeNodeX {
    int val;
    TreeNodeX left;
    TreeNodeX right;
    TreeNodeX next;

    TreeNodeX(int x) {
        val = x;
        left = right = next = null;
    }

    // level order traversal using 'next' pointer
    void printLevelOrder() {
        TreeNodeX nextLevelRoot = this;
        while (nextLevelRoot != null) {
            TreeNodeX current = nextLevelRoot;
            nextLevelRoot = null;
            while (current != null) {
                System.out.print(current.val + " ");
                if (nextLevelRoot == null) {
                    if (current.left != null)
                        nextLevelRoot = current.left;
                    else if (current.right != null)
                        nextLevelRoot = current.right;
                }
                current = current.next;
            }
            System.out.println();
        }
    }
};

class ConnectLevelOrderSiblings {
    public static void connect(TreeNodeX root) {
        if (root == null) {
            return;
        }
        Queue<TreeNodeX> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            TreeNodeX linkRoot = null;
            for (int i = 0; i <levelSize; i++) {
                TreeNodeX currentNode = queue.poll();
                if (linkRoot == null) {
                    linkRoot = currentNode;
                } else {
                    linkRoot.next = currentNode;
                    linkRoot = linkRoot.next;
                }
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
            linkRoot.next = null;
        }
    }

    public static void main(String[] args) {
        TreeNodeX root = new TreeNodeX(12);
        root.left = new TreeNodeX(7);
        root.right = new TreeNodeX(1);
        root.left.left = new TreeNodeX(9);
        root.right.left = new TreeNodeX(10);
        root.right.right = new TreeNodeX(5);
        ConnectLevelOrderSiblings.connect(root);
        System.out.println("Level order traversal using 'next' pointer: ");
        root.printLevelOrder();
    }
}
