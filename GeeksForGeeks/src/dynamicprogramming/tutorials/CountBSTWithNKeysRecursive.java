package dynamicprogramming.tutorials;

public class CountBSTWithNKeysRecursive {

    public static int countBST (int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        int count = 0;
        for (int index = 0; index < n; index++) {
            count += countBST(n-1-index) * countBST(index);
        }

        return count;
    }

    public static void main (String[] args) {
        System.out.println(countBST(4));
    }
}
