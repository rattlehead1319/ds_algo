package problems.medium.graph;

import java.util.*;

class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

public class CloneGraph {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        Map<Integer, Node> visited = new HashMap<>();
        return cloneGraph(node, visited);
    }

    private Node cloneGraph(Node node, Map<Integer, Node> visited) {
        if (visited.containsKey(node.val)) {
            return visited.get(node.val);
        }
        Node copy = new Node(node.val);
        visited.put(copy.val, copy);

        for (Node neighbor: node.neighbors) {
            copy.neighbors.add(cloneGraph(neighbor, visited));
        }

        return copy;
    }
}
