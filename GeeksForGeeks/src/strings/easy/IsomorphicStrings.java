package strings.easy;

public class IsomorphicStrings {
    public static boolean areIsomorphic(String str1,String str2)
    {
        if (str1.length() != str2.length()) {
            return false;
        }

        char[] charArray1 = new char[256];
        char[] charArray2 = new char[256];

        for (int i = 0; i < str1.length(); i++) {
            charArray1[str1.charAt(i)]++;
            charArray2[str2.charAt(i)]++;
        }

        for (int i = 0; i < str1.length(); i++) {
            if (charArray1[str1.charAt(i)] != charArray2[str2.charAt(i)]) {
                return false;
            }
        }
        return true;
    }
}
