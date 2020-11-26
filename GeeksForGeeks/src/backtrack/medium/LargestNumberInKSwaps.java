package backtrack.medium;

public class LargestNumberInKSwaps {
    public static String max;
    public static String findMaximumNum(String str, int k)
    {
        max = str;
        permute(str.toCharArray(), k);
        return max;
    }

    private static void permute (char[] chars, int k) {
        if (k == 0) {
            return;
        }

        int n = chars.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (chars[i] < chars[j]) {

                    char t = chars[i];
                    chars[i] = chars[j];
                    chars[j] = t;

                    if (String.valueOf(chars).compareTo(max) > 0) {
                        max = String.valueOf(chars);
                    }
                    permute(chars, k-1);

                    //Backtrack
                    t = chars[i];
                    chars[i] = chars[j];
                    chars[j] = t;
                }
            }
        }
    }
}
