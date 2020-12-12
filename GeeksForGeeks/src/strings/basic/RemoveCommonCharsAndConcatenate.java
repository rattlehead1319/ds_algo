package strings.basic;

public class RemoveCommonCharsAndConcatenate {
    public static String concatenatedString(String s1,String s2){

        int[] dc1 = new int[256];
        int[] dc2 = new int[256];

        for (int i = 0; i < s1.length(); i++) {
            dc1[s1.charAt(i)]++;
        }

        for (int i = 0; i < s2.length(); i++) {
            dc2[s2.charAt(i)]++;
        }

        String result = "";
        for (int i = 0; i < s1.length(); i++) {
            int x = s1.charAt(i);
            if (dc2[x] > 0) {
                continue;
            }
            result += s1.charAt(i);
        }

        for (int i = 0; i < s2.length(); i++) {
            int x = s2.charAt(i);
            if (dc1[x] > 0) {
                continue;
            }
            result += s2.charAt(i);
        }
        return result.equals("") ? "-1" : result;
    }

    public static void main(String[] args) {
        String S = "i.like.this.program.very.much";
        String[] arr = S.split("\\.");
        System.out.println(arr.length);
    }
}
