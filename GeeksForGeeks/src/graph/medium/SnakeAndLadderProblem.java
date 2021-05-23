package graph.medium;

import java.util.*;

class Helper4 {
    int v;
    int dist;

    Helper4() {}

    Helper4 (int v, int dist) {
        this.v = v;
        this.dist = dist;
    }
}

public class SnakeAndLadderProblem {
    static int minThrow(int N, int arr[]){
        int[] moves = new int[31];
        Arrays.fill(moves, -1);

        for (int i = 0; i < N; i++) {
            moves[arr[2*i]] = arr[2*i+1];
        }

        Queue<Helper4> queue = new LinkedList<>();
        queue.add(new Helper4(1, 0));

        boolean[] visited = new boolean[31];
        visited[1] = true;

        while (!queue.isEmpty()) {
            Helper4 h = queue.poll();
            int v = h.v;

            if (v == 30) {
                return h.dist;
            }

            for (int j = v+1; j <= (v+6) && j <= 30; j++) {

                if (visited[j]) {
                    continue;
                }
                visited[j] = true;

                Helper4 nh = new Helper4();
                if (moves[j] != -1) {
                    nh.v = moves[j];
                } else {
                    nh.v = j;
                }
                nh.dist = h.dist + 1;
                queue.add(nh);
            }
        }
        return -1;
    }
}
