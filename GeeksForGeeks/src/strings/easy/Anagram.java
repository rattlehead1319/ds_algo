package strings.easy;

public class Anagram {
    public static boolean isAnagram(String a,String b)
    {

        char[] charCounts = new char[256];
        for (int i = 0; i < a.length(); i++) {
            charCounts[a.charAt(i)]++;
        }

        for (int i = 0; i < b.length(); i++) {
            charCounts[b.charAt(i)]--;
        }

        for (int i = 0; i < charCounts.length; i++) {
            if (charCounts[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
