package problems.medium.maths;

public class AngleBetweenHandsOfAClock {
    public double angleClock(int hour, int minutes) {
        double minuteAngle = minutes * 360 / 60;
        if (hour == 12) {
            hour = 0;
        }
        double hourAngle = (hour * 5 * 360 / 60) + minutes * 0.5;
        double result =  Math.abs(hourAngle - minuteAngle);
        if (result > 180) {
            result = 360 - result;
        }
        return result;
    }
}
