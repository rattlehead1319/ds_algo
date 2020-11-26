package backtrack.medium;

class Helper {
    long count = 0;
}

public class BlackAndWhite {
    static long solve(int N, int M) {
        long totalCount = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                Helper h = new Helper();
                move(i, j, N, M, h);
                totalCount += N*M - h.count - 1;
            }
        }
        return totalCount;
    }

    static void move (int row, int col, int N, int M, Helper h) {

        int[] X = new int[]{-2, -1, 1, 2, 2, 1, -1, -2};
        int[] Y = new int[]{1, 2, 2, 1, -1, -2, -2, -1};

        for (int k = 0; k < 8; k++) {
            int nextRow = row + X[k];
            int nextCol = col + Y[k];
            if (isSafe(nextRow, nextCol, N, M)) {
                h.count++;
            }
        }
    }

    static boolean isSafe (int row, int col, int N, int M) {
        return row >= 0 && row < N && col >= 0 && col < M;
    }
}
