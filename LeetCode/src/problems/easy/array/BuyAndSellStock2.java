package problems.easy.array;

public class BuyAndSellStock2 {
    public int maxProfit(int[] prices) {
        int start = 0;
        int end = 0;

        int index = 0;
        int profit = 0;
        while (index < prices.length) {
            while (index + 1 < prices.length && prices[index] >= prices[index + 1]) {
                index++;
            }
            int buy = index;
            while (index + 1 < prices.length && prices[index] <= prices[index + 1]) {
                index++;
            }
            profit += prices[index] - prices[buy];
            index++;
        }

        return profit;
    }
}
