package problems.medium.tree;

import java.util.*;

public class ExpressionTreeWithEvaluateFunction {
    abstract class Node {
        public abstract int evaluate();
        // define your fields here
    };

    class TreeNode extends Node {
        public TreeNode left;
        public TreeNode right;
        public String val;

        TreeNode (String val) {
            this.val = val;
        }

        @Override
        public int evaluate() {
            int left = 0;
            if (this.left != null &&
                    (this.left.val.equals("+") || this.left.val.equals("-") ||
                            this.left.val.equals("/") || this.left.val.equals("*")
                    )
            )
            {
                left = this.left.evaluate();
            } else if (this.left != null) {
                left = Integer.parseInt(this.left.val);
            }
            int right = 0;
            if (this.right != null &&
                    (this.right.val.equals("+") || this.right.val.equals("-") ||
                            this.right.val.equals("/") || this.right.val.equals("*")
                    )
            )
            {
                right = this.right.evaluate();
            } else if (this.right != null) {
                right = Integer.parseInt(this.right.val);
            }
            if (this.val.equals("+")) {
                return left + right;
            } else if (this.val.equals("-")) {
                return left - right;
            } else if (this.val.equals("*")) {
                return left * right;
            } else if (this.val.equals("/")) {
                return left / right;
            }
            return -1;
        }
    }

    Node buildTree(String[] postfix) {
        Stack<TreeNode> stack = new Stack<>();
        for (String exp: postfix) {
            TreeNode newNode = new TreeNode(exp);
            if (exp.equals("*") || exp.equals("-") || exp.equals("/") || exp.equals("+")) {
                TreeNode right = stack.pop();
                TreeNode left = stack.pop();
                newNode.left = left;
                newNode.right = right;
            }
            stack.push(newNode);
        }
        return stack.pop();
    }
}

/**
 * Your ExpressionTreeWithEvaluateFunction object will be instantiated and called as such:
 * ExpressionTreeWithEvaluateFunction obj = new ExpressionTreeWithEvaluateFunction();
 * Node expTree = obj.buildTree(postfix);
 * int ans = expTree.evaluate();
 */