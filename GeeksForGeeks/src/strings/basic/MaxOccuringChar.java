package strings.basic;

public class MaxOccuringChar {
    public static char getMaxOccuringChar(String line){

        int[] dc = new int[256];


        for (int i = 0; i < line.length(); i++) {
            dc[line.charAt(i)]++;
        }

        int result = Integer.MIN_VALUE;
        int index = 0;
        for (int i = 0; i < dc.length; i++) {
            if (dc[i] > result) {
                result = dc[i];
                index = i;
            }
        }
        return (char)index;
    }
}
