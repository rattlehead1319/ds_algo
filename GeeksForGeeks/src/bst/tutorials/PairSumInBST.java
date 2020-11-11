package bst.tutorials;

import java.util.*;

public class PairSumInBST {
    boolean findPair (Node root, int sum, Set<Integer> set) {
        if (root == null) {
            return false;
        }
        if (findPair(root.left, sum, set)) {
            return true;
        }
        if (set.contains(sum - root.data)) {
            return true;
        } else {
            set.add(root.data);
        }
        return findPair(root.right, sum, set);
    }
}
