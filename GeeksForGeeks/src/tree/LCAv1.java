package tree;

import java.util.*;

public class LCAv1  {
    static class Node {
        int data;
        Node left;
        Node right;
    }

    static Node findLCA (Node root, int num1, int num2) {
        List<Node> path1 = new ArrayList<>();
        List<Node> path2 = new ArrayList<>();

        if (!findPath(root, path1, num1) || !findPath(root, path2, num2)) {
            return null;
        }

        for (int index = 0; index < path1.size() && index < path2.size(); index++) {
            if (path1.get(index).data != path2.get(index).data) {
                return path1.get(index - 1);
            }
        }
        return null;
    }

    static boolean findPath(Node root, List<Node> path, int num) {
        if (root == null) {
            return false;
        }
        path.add(root);
        if (root.data == num) {
            return true;
        }
        if (findPath(root.left, path, num) || findPath(root.right, path, num)) {
            return true;
        }
        path.remove(path.size() - 1);
        return false;
    }
}

