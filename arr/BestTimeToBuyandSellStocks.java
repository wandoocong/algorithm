package arr;

import java.util.*;
public class BestTimeToBuyandSellStocks {
    public static void main(String[] args) {

        int[] arr = {8, 1, 5, 3, 6, 4};
        BestTimeToBuyandSellStocks bestTimeToBuyandSellStocks = new BestTimeToBuyandSellStocks();
        int answer = bestTimeToBuyandSellStocks.maxProfit(arr);

        System.out.println("answer = " + answer);

    }

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = prices[0];

        for (int i = 0; i < prices.length; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            maxProfit = Math.max(prices[i] - minPrice, maxProfit);
        }

        return maxProfit;
    }

}
