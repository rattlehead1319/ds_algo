package searching.easy;

public class IndexOfAnExtraElement {
    public int findExtra(int a[], int b[], int n) {
        int l1 = 0;
        int r1 = a.length - 1;
        int l2 = 0;
        int r2 = b.length - 1;

        int result = 0;
        while (l1 <= r1 && l2 <= r2) {
            int m1 = l1 + (r1 - l1)/2;
            if (m1 > b.length - 1) {
                return m1;
            } else if (a[m1] < b[m1]) {
                result = m1;
                r1 = m1 - 1;
            } else {
                l1 = m1 + 1;
            }
        }

        return result;
    }
}
