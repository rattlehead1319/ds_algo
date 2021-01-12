package arrays.medium;

import java.util.*;

public class StockBuyAndSell {
    ArrayList<ArrayList<Integer> > stockBuySell(int A[], int n) {
        ArrayList<Integer> trade = new ArrayList<>();
        ArrayList<ArrayList<Integer>> trades = new ArrayList<>();


        int i = 0;
        while (i < n-1) {

            //find local minima
            while (i < n-1 && A[i+1] <= A[i]) {
                i++;
            }

            if (i == n-1) {
                break;
            }

            //should buy
            trade.add(i++);

            //find local maxima
            while (i < n && A[i] >= A[i-1]) {
                i++;
            }

            //should sell
            trade.add(i-1);
            trades.add(trade);
            trade = new ArrayList<>();
        }

        return trades;
    }
}
