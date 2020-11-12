package bst.problems.medium;

public class SmallerOnRight {

    static class Node {
        int data;
        Node left;
        Node right;
        Node (int data) {
            this.data = data;
        }
    }

    private static int maxSmallerCount = Integer.MIN_VALUE;

    public static void main (String[] args) {
        int[] arr = new int[]{10, 6, 9, 7, 20, 19, 21, 18, 17, 16};
        Node root = creatBST(arr);
        findMaxSmallerOnRight(root, 0);
        System.out.println("maxSmallerCount: " + maxSmallerCount);
    }

    private static Node creatBST (int[] arr) {
        if (arr.length == 0) {
            return null;
        }
        Node root = new Node(arr[0]);
        for (int index = 1; index < arr.length; index++) {
            createBSTRec(root, arr[index]);
        }
        return root;
    }

    private static Node createBSTRec(Node root, int x) {
        if (root == null) {
            return new Node(x);
        }
        if (x < root.data) {
            root.left = createBSTRec(root.left, x);
        } else {
            root.right = createBSTRec(root.right, x);
        }
        return root;
    }

    private static void findMaxSmallerOnRight (Node root, int leftDistance) {
        if (root == null) {
            return;
        }
        findMaxSmallerOnRight(root.left, leftDistance+1);
        maxSmallerCount = Math.max(maxSmallerCount, leftDistance);
        findMaxSmallerOnRight(root.right, 0);
    }
}
