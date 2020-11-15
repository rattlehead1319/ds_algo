package bst.problems.medium;

import java.util.*;

/**
 * Can space be optimised?
 */

public class MergeTwoBSTs {
    public List<Integer> merge(Node root1,Node root2)
    {
        List<Integer> result = new ArrayList<>();
        if (root1 == null && root2 == null) {
            return result;
        }

        List<Integer> list1 = new ArrayList<>();
        inOrder(root1, list1);
        List<Integer> list2 = new ArrayList<>();
        inOrder(root2, list2);

        int index1 = 0, index2 = 0;
        while (index1 < list1.size() && index2 < list2.size()) {
            if (list1.get(index1) < list2.get(index2)) {
                result.add(list1.get(index1));
                index1++;
            } else if (list2.get(index2) < list1.get(index1)) {
                result.add(list2.get(index2));
                index2++;
            } else {
                result.add(list1.get(index1));
                index1++;
                result.add(list2.get(index2));
                index2++;
            }
        }
        while (index1 < list1.size()) {
            result.add(list1.get(index1));
            index1++;
        }
        while (index2 < list2.size()) {
            result.add(list2.get(index2));
            index2++;
        }
        return result;
    }

    private void inOrder (Node root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inOrder(root.left, list);
        list.add(root.data);
        inOrder(root.right, list);
    }
}
