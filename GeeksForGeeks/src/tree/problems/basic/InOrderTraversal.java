package tree.problems.basic;

import java.util.*;

public class InOrderTraversal {
    ArrayList<Integer> inOrder(Node root)
    {
        ArrayList<Integer> inOrderList = new ArrayList<>();
        inOrderRec(root, inOrderList);
        return inOrderList;
    }

    void inOrderRec (Node root, List<Integer> inOrderList) {
        if (root == null) {
            return;
        }
        inOrderRec(root.left, inOrderList);
        inOrderList.add(root.data);
        inOrderRec(root.right, inOrderList);
    }
}
