package algorithm_part1.arr;

public class BestTimeToBuyandSellStocks {
    public static void main(String[] args) {

        int[] arr = {8, 1, 5, 3, 6, 4};
        int answer = maxProfit(arr);
        System.out.println("answer = " + answer);

    }

    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = prices[0];

        for (int i = 0; i < prices.length; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            maxProfit = Math.max(prices[i] - minPrice, maxProfit);
        }

        return maxProfit;
    }

}
