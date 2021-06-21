package problems.medium.bitwise;

public class MagicalString {
    public int magicalString(int n) {
        if (n <= 3) {
            return 1;
        }

        int[] magicArray = new int[n+1];
        magicArray[0] = 1;
        magicArray[1] = 2;
        magicArray[2] = 2;

        int i = 2;
        int j = 3;
        int x = 1;
        int res = 1;
        while (j < n) {
            for (int k = 0; k < magicArray[i]; k++) {
                if (j < n && x == 1) {
                    res++;
                }
                magicArray[j++] = x;
            }
            x = x^3;
            i++;
        }

        return res;
    }
}
