package problems.medium.logic;

import javafx.util.Pair;

import java.util.*;

class Relation {
    public boolean knows (int a, int b) {
        //this is for compilation purpose, actual implementation was hidden in the problem
        return true;
    }
}

public class FindTheCelebrity extends Relation {
    private Map<Pair<Integer, Integer>, Boolean> cache = new HashMap<>();

    @Override
    public boolean knows(int a, int b) {
        if (!cache.containsKey(new Pair(a, b))) {
            cache.put(new Pair(a, b), super.knows(a, b));
        }
        return cache.get(new Pair(a, b));
    }

    public int findCelebrity(int n) {
        int celebrityCandidate = 0;
        for (int i = 0; i < n; i++) {
            if (knows(celebrityCandidate, i)) {
                celebrityCandidate = i;
            }
        }

        if (isCelebrity(celebrityCandidate, n)) {
            return celebrityCandidate;
        }

        return -1;
    }

    private boolean isCelebrity(int i, int n) {
        for (int j = 0; j < n; j++) {
            if (i == j) {
                continue;
            }
            if (knows(i,j) || !knows(j, i)) {
                return false;
            }
        }
        return true;
    }
}
