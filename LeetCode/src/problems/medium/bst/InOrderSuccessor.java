package problems.medium.bst;

import apple.laf.JRSUIUtils;

import java.util.*;

public class InOrderSuccessor {
    class Solution {
        public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
            //return mySolution(root, p);
            return lcSolution(root, p);
        }

        private TreeNode lcSolution(TreeNode root, TreeNode p) {
            TreeNode successor = null;

            while (root != null) {

                if (p.val >= root.val) {
                    root = root.right;
                } else {
                    successor = root;
                    root = root.left;
                }
            }

            return successor;
        }

        private TreeNode mySolution (TreeNode root, TreeNode p) {
            List<TreeNode> list = new ArrayList<>();
            inorderSuccessor(root, list);
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).val == p.val && i < list.size() - 1) {
                    return list.get(i+1);
                }
            }
            return null;
        }

        private void inorderSuccessor(TreeNode root, List<TreeNode> list) {
            if (root == null) {
                return;
            }
            inorderSuccessor(root.left, list);
            list.add(root);
            inorderSuccessor(root.right, list);
        }
    }
}
