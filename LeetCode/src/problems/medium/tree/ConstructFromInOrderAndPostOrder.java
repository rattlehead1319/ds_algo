package problems.medium.tree;

import java.util.*;

class Helper1 {
    int postIndex;
    Helper1 (int n) {
        postIndex = n;
    }
}

public class ConstructFromInOrderAndPostOrder {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = inorder.length;

        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }

        Helper1 h = new Helper1(n-1);
        return buildTreeRec(postorder, 0, n-1, h, map);
    }

    private TreeNode buildTreeRec(int[] post, int l, int r, Helper1 h, Map<Integer, Integer> map) {
        if (l > r) {
            return null;
        }

        TreeNode root = new TreeNode(post[h.postIndex--]);
        int inIndex = map.get(root.val);
        root.right = buildTreeRec(post, inIndex + 1, r, h, map);
        root.left = buildTreeRec(post, l, inIndex - 1, h, map);

        return root;
    }
}
