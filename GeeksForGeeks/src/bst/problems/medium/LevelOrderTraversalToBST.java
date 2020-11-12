package bst.problems.medium;

import java.util.*;

/***
 * Good one
 */

class NodeRange {
    Node node;
    int min;
    int max;
    NodeRange (Node node, int min, int max) {
        this.node = node;
        this.min = min;
        this.max = max;
    }
}

public class LevelOrderTraversalToBST {
    public Node constructBST(int[] arr){
        if (arr.length == 0) {
            return null;
        }

        Queue<NodeRange> queue = new LinkedList<>();
        Node root = new Node(arr[0]);
        queue.add(new NodeRange(root, Integer.MIN_VALUE, Integer.MAX_VALUE));

        int index = 1;
        while (!queue.isEmpty() && index < arr.length) {
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                NodeRange current = queue.poll();
                Node node = current.node;
                int min = current.min;
                int max = current.max;

                if (index < arr.length && arr[index] > min && arr[index] < node.data) {
                    Node leftNode = new Node(arr[index++]);
                    node.left = leftNode;
                    queue.add(new NodeRange(leftNode, min, node.data));
                }
                if (index < arr.length && arr[index] < max && arr[index] > node.data) {
                    Node rightNode = new Node(arr[index++]);
                    node.right = rightNode;
                    queue.add(new NodeRange(rightNode, node.data, max));
                }
            }
        }
        return root;
    }
}
