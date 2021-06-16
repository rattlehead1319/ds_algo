package problems.easy.strings;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        String result = "";
        int shortestWordlength = Integer.MAX_VALUE;
        for (String s: strs) {
            shortestWordlength = Math.min(shortestWordlength, s.length());
        }
        int index = 0;
        while (index < shortestWordlength) {
            for (int i = 0; i < strs.length - 1; i++) {
                if (strs[i].charAt(index) != strs[i+1].charAt(index)) {
                    return result;
                }
            }
            result += Character.toString(strs[0].charAt(index));
            index++;
        }
        return result;
    }
}
