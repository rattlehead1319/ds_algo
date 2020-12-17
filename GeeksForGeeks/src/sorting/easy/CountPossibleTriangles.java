package sorting.easy;

import java.util.*;

public class CountPossibleTriangles {
    static int findNumberOfTriangles(int arr[], int n)
    {
        Arrays.sort(arr);
        int count=0,i;
        for(i=n-1;i>=1;i--){
            int l=0,r=i-1;
            while(l<r){
                if(arr[l]+arr[r]>arr[i]){
                    count+=r-l;
                    r--;
                }
                else
                    l++;
            }
        }
        return count;
    }
}
