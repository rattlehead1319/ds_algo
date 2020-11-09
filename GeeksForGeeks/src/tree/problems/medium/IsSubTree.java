package tree.problems.medium;

import java.util.*;

class Node {
    int data;
    Node left;
    Node right;
    Node (int data) {
        this.data = data;
    }
}

public class IsSubTree {
    public static boolean isSubtree(Node T, Node S) {
        List<Integer> list = preOrder(T);
        List<Integer> sublist = preOrder(S);
        return Collections.indexOfSubList(list, sublist) != -1;
    }

    private static List<Integer> preOrder(Node root) {
        List<Integer> preList = new ArrayList<>();
        if (root == null) {
            return preList;
        }
        preOrderRec(root, preList);
        return preList;
    }

    private static void preOrderRec(Node root, List<Integer> preList) {
        if (root == null) {
            preList.add(-1);
            return;
        }
        preList.add(root.data);
        preOrderRec(root.left, preList);
        preOrderRec(root.right, preList);
    }
}
