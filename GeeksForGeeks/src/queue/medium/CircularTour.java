package queue.medium;

import java.util.*;

public class CircularTour {

    int tour(int petrol[], int distance[])
    {
        Queue<Integer> q = new LinkedList<>();
        int size = petrol.length;
        int i = 0;
        int currPetrol = 0;
        int count = 0;
        while (true) {
            if (q.size() == size) {
                return q.poll();
            }
            if (count == 2*size) {
                return -1;
            }
            currPetrol += petrol[i] - distance[i];
            q.offer(i);
            while (currPetrol < 0) {
                int index = q.poll();
                currPetrol -= (petrol[index] - distance[index]);
            }

            i = (i+1)%size;
            count++;
        }
    }
}
