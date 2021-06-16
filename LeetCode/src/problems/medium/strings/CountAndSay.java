package problems.medium.strings;

public class CountAndSay {
    public String countAndSay(int n) {
        String curr = "1";
        curr = countAndSayRec(curr, 1, n);
        return curr;
    }

    private String countAndSayRec(String curr, int count, int n) {
        if (count == n) {
            return curr;
        }
        String next = "";
        char prev = curr.charAt(0);
        int x = 1;
        for (int i = 1; i < curr.length(); i++) {
            if (curr.charAt(i) != prev) {
                next += String.valueOf(x) + Character.toString(prev);
                x = 1;
            } else {
                x++;
            }
            prev = curr.charAt(i);
        }
        next += String.valueOf(x) + Character.toString(curr.charAt(curr.length() - 1));
        curr = next;
        return countAndSayRec(curr, count+1, n);
    }
}
