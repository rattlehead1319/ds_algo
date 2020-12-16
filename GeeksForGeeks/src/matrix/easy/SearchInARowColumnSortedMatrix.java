package matrix.easy;

public class SearchInARowColumnSortedMatrix {
    static boolean search(int matrix[][], int n, int m, int x)
    {
        int p = 0;
        int q = m -1;

        while (p < n && q >= 0) {
            if (matrix[p][q] == x) {
                return true;
            }
            if (x > matrix[p][q]) {
                p++;
            } else {
                q--;
            }
        }
        return false;
    }
}
