package strings.easy;

public class TheModifiedString {
    public static long modified(String a){
        int cons = 0;
        long count = 0;
        Character prev = null;
        for (int i = 0; i < a.length(); i++) {
            if (prev != null && prev == a.charAt(i)) {
                cons++;
            } else {
                cons = 0;
            }
            if (cons == 2) {
                count++;
                cons = 0;
            }
            prev = a.charAt(i);
        }
        return count;
    }
}
