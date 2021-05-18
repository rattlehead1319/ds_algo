package tree.problems.medium;
import java.util.*;

class Helper {
    int preIndex;
}

public class TreeFromInorderAndPreorder {
    public static Node buildTree(int inorder[], int preorder[], int n)
    {
        Map<Integer, Integer> inOrderElementIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inOrderElementIndexMap.put(inorder[i], i);
        }

        if (n == 0) {
            return null;
        }

        Helper h = new Helper();
        return constructTree(preorder, h,0, inorder.length - 1, inOrderElementIndexMap);
    }

    private static Node constructTree(int[] pre, Helper h, int start, int end, Map<Integer, Integer> map) {
        if (start > end) {
            return null;
        }

        Node root = new Node(pre[h.preIndex++]);
        int inorderIndex = map.get(root.data);

        root.left = constructTree(pre, h, start, inorderIndex - 1, map);
        root.right = constructTree(pre, h, inorderIndex + 1, end, map);

        return root;
    }
}
