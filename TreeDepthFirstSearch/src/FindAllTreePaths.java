import java.util.*;

public class FindAllTreePaths {
    public static List<List<Integer>> findPaths(TreeNode root, int sum) {
        List<List<Integer>> allPaths = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        traverse(root, sum, allPaths, path);
        return allPaths;
    }

    private static void traverse(TreeNode root, int sum, List<List<Integer>> allPaths, List<Integer> path) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        if (root.val == sum && root.right == null && root.left == null) {
            allPaths.add(path);
        }
        traverse(root.left, sum - root.val, allPaths, path);
        traverse(root.right, sum - root.val, allPaths, path);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        int sum = 23;
        List<List<Integer>> result = FindAllTreePaths.findPaths(root, sum);
        System.out.println("Tree paths with sum " + sum + ": " + result);
    }
}
