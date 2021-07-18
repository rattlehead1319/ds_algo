package problems.easy.matrix;

public class FloodFills {
    private int[] rows = new int[]{0, -1, 0, 1};
    private int[] cols = new int[]{-1, 0, 1, 0};

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int m = image.length;
        int n = image[0].length;
        boolean[][] visited  = new boolean[m][n];

        floodFill(image, sr, sc, visited, newColor, image[sr][sc]);
        return image;
    }

    private void floodFill(int[][] image, int row, int col, boolean[][] visited, int newColor, int startingColor) {
        visited[row][col] = true;
        image[row][col] = newColor;

        for (int i = 0; i < 4; i++) {
            int newRow = row + rows[i];
            int newCol = col + cols[i];
            if (newRow >= 0 && newRow < image.length && newCol >= 0 && newCol < image[0].length &&
                    !visited[newRow][newCol] && image[newRow][newCol] == startingColor)
            {
                floodFill(image, newRow, newCol, visited, newColor, startingColor);
            }
        }
    }
}
