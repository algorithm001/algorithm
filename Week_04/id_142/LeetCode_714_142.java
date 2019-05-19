class Solution {
    public int maxProfit(int[] prices, int fee) {
        int sell = 0, buy = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            sell = Math.max(sell, buy + prices[i] - fee);
            buy = Math.max(buy, sell - prices[i]);
        }
        return sell;
    }
}
