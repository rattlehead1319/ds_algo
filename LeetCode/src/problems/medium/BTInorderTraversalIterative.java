package problems.medium;

import java.util.*;

public class BTInorderTraversalIterative {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        //inorderTraversalRecursive(root, result);
        inorderTraversalIterative(root, result);
        return result;
    }

    private void inorderTraversalRecursive(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }

        inorderTraversalRecursive(root.left, result);
        result.add(root.val);
        inorderTraversalRecursive(root.right, result);
    }

    private void inorderTraversalIterative(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            result.add(current.val);

            current = current.right;
        }
    }

}
