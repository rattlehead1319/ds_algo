package bst.problems.medium;

public class ClosestElementInBST {
    static int maxDiff(Node  root, int K)
    {
        if (root == null) {
            return K;
        }

        int ceil = 0, floor = 0;
        while (root != null) {
            if (root.data == K) {
                return 0;
            } else if (K < root.data) {
                ceil = root.data;
                root = root.left;
            } else {
                floor = root.data;
                root = root.right;
            }
        }

        if (ceil != 0 && floor != 0 && ceil - K < K - floor) {
            return ceil - K;
        } else if (ceil != 0 && floor != 0 && ceil - K > K - floor) {
            return K - floor;
        } else if (ceil != 0) {
            return ceil - K;
        } else if (floor != 0) {
            return K - floor;
        }
        return K;
    }
}
