package tree;

public class BurnTheTree {
    static class Node {
        int data;
        Node left;
        Node right;
    }

    static class Distance {
        int value;
        Distance (int value) {
            this.value = value;
        }
    }

    static int result = Integer.MIN_VALUE;
    static int burnTree (Node root, int leaf, Distance dist) {
        if (root == null) {
            return 0;
        }
        if (root.data == leaf) {
            dist.value = 0;
            return 1;
        }
        Distance leftDist = new Distance(-1);
        Distance rightDist = new Distance(-1);

        int leftHeight = burnTree(root.left, leaf, leftDist);
        int rightHeight = burnTree(root.right, leaf, rightDist);

        if (leftDist.value != -1) {
            dist.value = leftDist.value + 1;
            result = Math.max(result, rightHeight + dist.value);
        }
        if (rightDist.value != -1) {
            dist.value = rightDist.value + 1;
            result = Math.max(result, leftHeight + dist.value);
        }
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
