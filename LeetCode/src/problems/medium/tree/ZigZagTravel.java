package problems.medium.tree;

import java.util.*;

public class ZigZagTravel {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        stack1.push(root);
        List<Integer> list = new ArrayList<>();

        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            list = new ArrayList<>();

            while (!stack1.isEmpty()) {

                TreeNode curr = stack1.pop();
                list.add(curr.val);

                if (curr.left != null) {
                    stack2.push(curr.left);
                }
                if (curr.right != null) {
                    stack2.push(curr.right);
                }
            }

            if (!list.isEmpty()) {
                result.add(list);
            }
            list = new ArrayList<>();

            while (!stack2.isEmpty()) {

                TreeNode curr = stack2.pop();
                list.add(curr.val);

                if (curr.right != null) {
                    stack1.push(curr.right);
                }
                if (curr.left != null) {
                    stack1.push(curr.left);
                }
            }

            if (!list.isEmpty()) {
                result.add(list);
            }
        }
        return result;
    }
}
