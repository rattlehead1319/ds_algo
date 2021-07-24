package problems.medium.stack;

import java.util.*;

public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> stack = new Stack<>();
        for (int asteroid: asteroids) {
            boolean addAsteroid = true;
            while (!stack.isEmpty() && asteroid < 0 && stack.peek() > 0) {
                if (stack.peek() > (0 - asteroid)) {
                    addAsteroid = false;
                    break;
                } else if (stack.peek() < (0 - asteroid)) {
                    stack.pop();
                } else {
                    addAsteroid = false;
                    stack.pop();
                    break;
                }
            }
            if (addAsteroid) {
                stack.push(asteroid);
            }
        }

        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }
}
