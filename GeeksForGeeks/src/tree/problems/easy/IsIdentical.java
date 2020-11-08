package tree.problems.easy;

import java.util.*;

class Node {
    int data;
    Node left;
    Node right;
    Node (int data) {
        this.data = data;
    }

}

public class IsIdentical {
    boolean isIdentical(Node root1, Node root2)
    {
        List<Integer> preOrder1 = preOrder(root1);
        List<Integer> preOrder2 = preOrder(root2);
        if (preOrder1.size() != preOrder2.size()) {
            return false;
        }
        int index = 0;
        while (index < preOrder1.size()) {
            if (!preOrder1.get(index).equals(preOrder2.get(index))) {
                return false;
            }
            index++;
        }
        return true;
    }

    List<Integer> preOrder(Node root) {
        List<Integer> preOrderList = new ArrayList<>();
        preOrderRec(root, preOrderList);
        return preOrderList;
    }

    void preOrderRec (Node root, List<Integer> preOrderList) {
        if (root == null) {
            preOrderList.add(-1);
            return;
        }
        preOrderList.add(root.data);
        preOrderRec(root.left, preOrderList);
        preOrderRec(root.right, preOrderList);
    }
}
