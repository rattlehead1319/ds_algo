package problems.medium.tree;

import java.util.*;

class Helper {
    int preIndex;
}

public class ConstructTreeFromInOrderAndPreOrder {
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        Map<Integer, Integer> indexMap = new HashMap<>();
        int n = preorder.length;

        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }

        Helper h = new Helper();
        return buildTreeRec(preorder, 0, n-1, h, indexMap);
    }

    private TreeNode buildTreeRec(int[] pre, int start, int end,
                                  Helper h, Map<Integer, Integer> indexMap)
    {
        if (start > end) {
            return null;
        }

        TreeNode root = new TreeNode(pre[h.preIndex++]);
        int inIndex = indexMap.get(root.val);

        root.left = buildTreeRec(pre, start, inIndex - 1, h, indexMap);
        root.right = buildTreeRec(pre, inIndex + 1, end, h, indexMap);

        return root;
    }
}
