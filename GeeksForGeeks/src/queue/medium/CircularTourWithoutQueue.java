package queue.medium;

public class CircularTourWithoutQueue {
    int tour(int petrol[], int distance[]) {
        int n = petrol.length;
        int currPetrol = 0, prevPetrol = 0, start = 0;
        for (int i = 0; i < n; i++) {
            currPetrol += petrol[i] - distance[i];
            if (currPetrol < 0) {
                start = i + 1;
                prevPetrol += currPetrol;
                currPetrol = 0;
            }
        }
        return currPetrol + prevPetrol >= 0 ? start : -1;
    }
}
