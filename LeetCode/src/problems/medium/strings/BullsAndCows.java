package problems.medium.strings;

public class BullsAndCows {
    public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;

        int[] chars = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bulls++;
            } else {
                int x = secret.charAt(i) - '0';
                int y = guess.charAt(i) - '0';
                if (chars[x] < 0) {
                    cows++;
                }
                if (chars[y] > 0) {
                    cows++;
                }
                chars[x]++;
                chars[y]--;
            }
        }

        StringBuilder sb = new StringBuilder("");
        sb.append(bulls);
        sb.append("A");
        sb.append(cows);
        sb.append("B");

        return sb.toString();
    }
}
