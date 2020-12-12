package strings.basic;

public class SumOfNumbersInAString {
    public static long findSum(String s){

        long result = 0;
        String num = "";
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                num += Character.toString(s.charAt(i));
            } else {
                if (!"".equals(num)) {
                    result += Long.parseLong(num);
                }
                num = "";
            }
        }
        if (!"".equals(num)) {
            result += Long.valueOf(num);
        }
        return result;
    }
}
