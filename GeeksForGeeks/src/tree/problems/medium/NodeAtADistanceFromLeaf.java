package tree.problems.medium;

public class NodeAtADistanceFromLeaf {
    class Result {
        int data;
    }

    int printKDistantfromLeaf(Node root, int k)
    {
        Result result = new Result();
        boolean visited[] = new boolean[100001];
        printKDistantfromLeafRec(root, k, result, 0, visited);
        return result.data;
    }

    void printKDistantfromLeafRec(Node root, int k, Result result, int level, boolean[] visited) {
        if (root == null) {
            return;
        }
        //Not sure..get clarification may b?
        visited[level++] = false;

        if (root.left == null && root.right == null && level-k-1 >= 0 && !visited[level-k-1]) {
            result.data++;
            visited[level-k-1] = true;
        }

        printKDistantfromLeafRec(root.left, k, result, level, visited);
        printKDistantfromLeafRec(root.right, k, result, level, visited);
    }
}
