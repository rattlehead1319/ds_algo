package strings.easy;

public class PangramCheck {
    public static boolean checkPangram  (String s)
    {
        int[] dc = new int[256];
        for (int i = 0; i < s.length(); i++) {
            dc[Character.toLowerCase(s.charAt(i))]++;
        }
        for (int i = 97; i <= 122; i++) {
            if (dc[i] == 0) {
                return false;
            }
        }
        return true;
    }
}
