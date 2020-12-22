package sorting.medium;

import java.util.*;

public class MinPlatforms {
    static int findPlatform(int arr[], int dep[], int n)
    {

        Arrays.sort(arr);
        Arrays.sort(dep);

        int result = 1;
        int platform = 1;

        int i = 1;
        int j = 0;

        while (i < n && j < n) {
            if (arr[i] <= dep[j]) {
                i++;
                platform++;
            } else if (arr[i] > dep[j]) {
                j++;
                platform--;
            }

            result = Math.max(result, platform);
        }
        return result;
    }
}
