package bst.problems.easy;

import java.util.*;

public class PrintElementsInGivenRange {
    public static ArrayList<Integer> printNearNodes(Node root, int low, int high)
    {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        printNearNodesRec(root, low, high, result);
        return result;
    }

    private static void printNearNodesRec(Node root, int low, int high, ArrayList<Integer> result) {
        if (root == null) {
            return;
        }
        printNearNodesRec(root.left, low, high, result);
        if (root.data >= low && root.data <= high) {
            result.add(root.data);
        }
        printNearNodesRec(root.right, low, high, result);
    }
}
