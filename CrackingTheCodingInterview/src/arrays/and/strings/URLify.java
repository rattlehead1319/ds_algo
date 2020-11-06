package arrays.and.strings;

/**
 * Little tricky if no extra space allowed
 */

public class URLify {
    void replacSpaces(char[] str, int length) {
        int spaceCount = 0;
        for (int index = 0; index < str.length; index++) {
            if (str[index] == ' ') {
                spaceCount++;
            }
        }

        int newLength = length + 2*spaceCount;
        for (int index = length - 1; index >= 0; index--) {
            if (str[index] == ' ') {
                str[newLength - 1] = '0';
                str[newLength - 2] = '2';
                str[newLength - 3] = '%';
                newLength = newLength - 3;
            } else {
                str[newLength - 1] = str[index];
                newLength--;
            }
        }
    }

}
