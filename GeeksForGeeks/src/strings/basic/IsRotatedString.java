package strings.basic;

public class IsRotatedString {
    public static boolean areRotations(String s1, String s2 )
    {
        if (s1.length() != s2.length()) {
            return false;
        }
        String s = s1+s1;
        return s.indexOf(s2) != -1;
    }
}
