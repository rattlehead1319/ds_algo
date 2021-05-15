import java.util.*;

public class BoatsToSavePeople {
    public int numRescueBoats(int[] people, int limit) {
        if (people.length == 1) {
            return 1;
        }
        
        Arrays.sort(people);
        
        int noOfBoats = 0;
        int left = 0;
        int right = people.length - 1;
        
        while (left <= right) {
            if (people[left] + people[right] > limit) {
                noOfBoats++;
                right--;
            } else if (people[left] + people[right] <= limit) {
                noOfBoats++;
                right--;
                left++;
            } else {
                noOfBoats++;
                left++;
            }
        }
        
        return noOfBoats;
    }
}
