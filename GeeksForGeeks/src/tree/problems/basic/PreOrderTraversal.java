package tree.problems.basic;

import java.util.*;

class Node{
     int data;
     Node left,right;
     Node(int d){
         data=d;
         left=right=null;
     }
 }

public class PreOrderTraversal {

    static ArrayList<Integer> preorder(Node root)
    {
        ArrayList<Integer> preOrderList = new ArrayList<>();
        preOrderRec(root, preOrderList);
        return preOrderList;
    }

    static void preOrderRec (Node root, List<Integer> preOrderList) {
        if (root == null) {
            return;
        }
        preOrderList.add(root.data);
        preOrderRec(root.left, preOrderList);
        preOrderRec(root.right, preOrderList);
    }
}
