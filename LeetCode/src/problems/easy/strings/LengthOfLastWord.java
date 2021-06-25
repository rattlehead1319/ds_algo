package problems.easy.strings;

public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        s = s.trim();  // trim the trailing spaces in the string
        return s.length() - s.lastIndexOf(" ") - 1;
    }
}
