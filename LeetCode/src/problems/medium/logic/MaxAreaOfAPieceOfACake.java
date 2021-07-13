package problems.medium.logic;

import java.util.*;

public class MaxAreaOfAPieceOfACake {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        long maxHeightDiff = horizontalCuts[0];
        for (int i = 1; i < horizontalCuts.length; i++) {
            long diff = horizontalCuts[i] - horizontalCuts[i-1];
            maxHeightDiff = Math.max(maxHeightDiff, diff);
        }
        maxHeightDiff = Math.max(maxHeightDiff, h - horizontalCuts[horizontalCuts.length - 1]);

        Arrays.sort(verticalCuts);
        long maxWidthDiff = verticalCuts[0];
        for (int i = 1; i < verticalCuts.length; i++) {
            long diff = verticalCuts[i] - verticalCuts[i-1];
            maxWidthDiff = Math.max(maxWidthDiff, diff);
        }
        maxWidthDiff = Math.max(maxWidthDiff, w - verticalCuts[verticalCuts.length - 1]);

        return (int)((maxHeightDiff * maxWidthDiff) % (1000000007));
    }
}
