package tree.problems.easy;

public class LongestConsecutiveSequence {
    public int longestConsecutive(Node root)
    {
        int[] max = new int[1];
        longestConsecutiveRecursive(root, null, 0, max);
        return max[0] == 0 ? -1 : 1 + max[0];
    }

    private void longestConsecutiveRecursive (Node root, Node prev, int count, int[] max) {
        if (root == null) {
            return;
        }

        if (prev != null && root.data - prev.data == 1) {
            count++;
        } else {
            count = 0;
        }
        max[0] = Math.max(max[0], count);
        prev = root;

        longestConsecutiveRecursive(root.left, prev, count, max);
        longestConsecutiveRecursive(root.right, prev, count, max);
    }
}
