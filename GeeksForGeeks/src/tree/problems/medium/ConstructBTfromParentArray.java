package tree.problems.medium;

import java.util.*;

public class ConstructBTfromParentArray {
    static class Helper {
        int left = -1;
        int right = -1;
    }

    public static Node createTree(int arr[], int n)
    {
        Node root = null;
        Map<Integer, Helper> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (arr[i] == -1) {
                root = new Node(i);
            } else {
                Helper h = map.get(arr[i]);
                if (h == null) {
                    h = new Helper();
                    h.left = i;
                    map.put(arr[i], h);
                } else {
                    h.right = i;
                }
            }
        }
        createTreeRec(root, map);
        return root;
    }

    private static void createTreeRec(Node root, Map<Integer, Helper> map) {
        if (root == null) {
            return;
        }
        int val = root.data;
        Helper h = map.get(val);
        if (h != null) {
            if (h.left != -1) {
                root.left = new Node(h.left);
            }
            if (h.right != -1) {
                root.right = new Node(h.right);
            }
        }
        createTreeRec(root.left, map);
        createTreeRec(root.right, map);
    }
}
