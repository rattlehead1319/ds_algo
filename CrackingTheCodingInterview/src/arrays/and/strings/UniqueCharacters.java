package arrays.and.strings;

public class UniqueCharacters {
    private static boolean checkUnique(String input) {
        if (input.length() > 128) {
            return false;
        }
        boolean[] chars = new boolean[128];
        for (int index = 0; index < input.length(); index++) {
            char val = input.charAt(index);
            if (chars[val]) {
                return false;
            }
            chars[val] = true;
        }
        return true;
    }
}
