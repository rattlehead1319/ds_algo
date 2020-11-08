package tree.problems.basic;

import java.util.*;

public class PostOrderTraversal {
    ArrayList<Integer> postOrder(Node root)
    {
        ArrayList<Integer> postOrderList = new ArrayList<>();
        postOrderRec(root, postOrderList);
        return postOrderList;
    }

    void postOrderRec (Node root, List<Integer> postOrderList) {
        if (root == null) {
            return;
        }
        postOrderRec(root.left, postOrderList);
        postOrderRec(root.right, postOrderList);
        postOrderList.add(root.data);
    }
}
