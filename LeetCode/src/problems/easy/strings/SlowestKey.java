package problems.easy.strings;

public class SlowestKey {
    public char slowestKey(int[] releaseTimes, String keysPressed) {

        char result = keysPressed.charAt(0);
        int maxTime = releaseTimes[0];

        for (int i = 1; i < releaseTimes.length; i++) {
            int time = releaseTimes[i] - releaseTimes[i-1];
            if (time > maxTime) {
                maxTime = time;
                result = keysPressed.charAt(i);
            } else if (time == maxTime) {
                result = Character.compare(result, keysPressed.charAt(i)) > 0 ? result : keysPressed.charAt(i);
            }
        }

        return result;
    }
}
