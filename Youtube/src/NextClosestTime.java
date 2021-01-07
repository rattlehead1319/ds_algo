
import java.util.*;

public class NextClosestTime {
    public String nextTime (String time) {
        Set<Character> digits = new HashSet<>();
        for (Character c : time.toCharArray()) {
            digits.add(c);
        }

        int minutes = Integer.parseInt(time.substring(0,2))*60;
        minutes += Integer.parseInt((time.substring(3)));

        while (true) {
            minutes = (minutes + 1) % (24*60);
            int[] nextTime = {minutes/60/10, minutes/60%10, minutes%60/10, minutes%60%10};

            boolean isValid = true;
            for (int digit : nextTime) {
                if (!digits.contains(digit)) {
                    isValid = false;
                    break;
                }
            }

            if (isValid) {
                return String.format("%02d:%02d", minutes/60, minutes%60);
            }
        }
    }
}
