package bst.tutorials;

import java.util.*;

class VerticalSumInBinaryTree {
    void printSum (Node root) {
        Map<Integer, Integer> treeMap = new TreeMap<>();
        printSumRec(root, treeMap, 0);
        for (Map.Entry<Integer, Integer> entry : treeMap.entrySet()) {
            System.out.print(entry.getValue() + " ");
        }
    }

    void printSumRec (Node root, Map<Integer, Integer> treeMap, int level) {
        if (root == null) {
            return;
        }
        printSumRec(root.left, treeMap, level - 1);
        if (treeMap.containsKey(level)) {
            treeMap.put(level, treeMap.get(level) + root.data);
        } else {
            treeMap.put(level, root.data);
        }
        printSumRec(root.right, treeMap, level + 1);
    }
}

