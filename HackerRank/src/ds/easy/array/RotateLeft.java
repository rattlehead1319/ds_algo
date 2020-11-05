package ds.easy.array;

import java.util.*;
public class RotateLeft {
    public static List<Integer> rotateLeft(int d, List<Integer> arr) {
        if (d == 0) {
            return arr;
        }
        List<Integer> output = new ArrayList<>();
        d = d % arr.size();
        int index = 0;
        for (index = d; index < arr.size(); index++) {
            output.add(arr.get(index));
        }
        for (index = 0; index < d; index++) {
            output.add(arr.get(index));
        }
        return output;
    }
}
