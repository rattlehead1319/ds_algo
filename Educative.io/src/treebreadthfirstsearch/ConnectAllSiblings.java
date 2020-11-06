package treebreadthfirstsearch;

import java.util.*;



class ConnectAllSiblings {
    public static void connect(TreeNodeX root) {
        if (root == null) {
            return;
        }
        Queue<TreeNodeX> queue = new LinkedList<>();
        queue.offer(root);
        TreeNodeX linkRoot = null;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();

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
        }
    }

    public static void main(String[] args) {
        TreeNodeX root = new TreeNodeX(12);
        root.left = new TreeNodeX(7);
        root.right = new TreeNodeX(1);
        root.left.left = new TreeNodeX(9);
        root.right.left = new TreeNodeX(10);
        root.right.right = new TreeNodeX(5);
        ConnectAllSiblings.connect(root);

        // level order traversal using 'next' pointer
        TreeNodeX current = root;
        System.out.println("Traversal using 'next' pointer: ");
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }
}