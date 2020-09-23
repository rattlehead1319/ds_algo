public class BackspaceCompareV1 {
    public static boolean compare(String str1, String str2) {

        int index1 = str1.length() - 1;
        int index2 = str2.length() - 1;

        while (index1 >= 0 && index2 >= 0) {
            if (str1.charAt(index1) == '#') {
                int cnt = getIndex(str1, index1);
                index1 = index1 - cnt;
            }
            if (str2.charAt(index2) == '#') {
                int cnt = getIndex(str2, index2);
                index2 = index2 - cnt;
            }
            if (str1.charAt(index1) != str2.charAt(index2)) {
                return false;
            } else {
                index1--;
                index2--;
            }
        }

        return true;
    }

    private static int getIndex(String str, int index) {
        int count = 2;
        int right = index - 1;
        int left = index - 2;
        while (str.charAt(left) == '#' || str.charAt(right) == '#' && left >=0 && right >=0) {
            if (str.charAt(left) == '#') {
                left = left - 2;
                count = count + 2;
            }
            if (str.charAt(right) == '#') {
                right = right - 2;
                count = count + 2;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(BackspaceCompareV1.compare("xy#z", "xzz#"));
        System.out.println(BackspaceCompareV1.compare("xy#z", "xyz#"));
        System.out.println(BackspaceCompareV1.compare("xp#", "xyz##"));
        System.out.println(BackspaceCompareV1.compare("xp#", "xyz#e##"));
        System.out.println(BackspaceCompareV1.compare("xywrrmp", "xywrrmu#p"));
    }
}
