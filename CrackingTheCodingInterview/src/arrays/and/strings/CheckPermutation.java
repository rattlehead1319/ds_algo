package arrays.and.strings;

public class CheckPermutation {
    static boolean checkPermutation (String string1, String string2) {
        int[] chars = new int[128];

        for (int index = 0; index < string1.length(); index++) {
            char c = string1.charAt(index);
            chars[c]++;
        }
        for (int index = 0; index < string2.length(); index++) {
            char c = string2.charAt(index);
            chars[c]--;
            if (chars[c] < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(checkPermutation("weirdo", "wrieod"));
        System.out.println(checkPermutation("applesauce", "honey"));
    }
}
