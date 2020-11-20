package graph.medium;

public class XTotalShapes {
    public static int Shape(String []arr,int n,int m)
    {
        boolean[][] visited = new boolean[n][m];

        int count = 0;
        for (int ri = 0; ri < n; ri++) {
            for (int ci = 0; ci < m; ci++) {
                if (!visited[ri][ci] && arr[ri].charAt(ci) == 'X') {
                    dfs(arr, ri, ci, visited);
                    count++;
                }
            }
        }
        return count;
    }

    private static void dfs (String []arr, int row, int col, boolean[][] visited) {
        visited[row][col] = true;

        int[] rowNhbr = new int[]{-1, 0, 0, 1};
        int[] colNhbr = new int[]{0, -1, 1, 0};

        for (int k = 0; k < 4; k++) {
            if (isSafe(arr, row + rowNhbr[k], col + colNhbr[k], visited)) {
                dfs(arr, row + rowNhbr[k], col + colNhbr[k], visited);
            }
        }
    }

    private static boolean isSafe (String []arr, int row, int col, boolean[][] visited) {
        return row >= 0 && row < arr.length && col >= 0 && col < arr[0].length() &&
                !visited[row][col] && arr[row].charAt(col) != 'O';
    }
}
