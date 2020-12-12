package strings.basic;

public class Isogram {
    static boolean isIsogram(String data){
        char[] distinctChars = new char[256];
        for (int i = 0; i < data.length(); i++) {
            distinctChars[data.charAt(i)]++;
            if (distinctChars[data.charAt(i)] > 1) {
                return false;
            }
        }
        return true;
    }
}
