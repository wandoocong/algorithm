package alogorithm_part2.Greedy;

public class BestTimetoBuyandSellStrock2 {
    public static void main(String[] args) {
        int[] prices = {8, 1, 5, 3, 6, 4};

        int i = maxProfit(prices);
        System.out.println("i = " + i);

    }

    public static int maxProfit(int[] prices) {
        int result = 0;

        for (int i = 0; i < prices.length-1; i++) {
            if (prices[i + 1] > prices[i]) {
                result += prices[i + 1] - prices[i];
            }
        }

        return result;
    }
}
