// https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
// 121.买卖股票的最佳时机
// 思路：其实就是求某个时间点左边的最小值和右边的最大值之差的最大值。
class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length <=0){
            return 0;
        }
        
        int minPrice = prices[0];
        int maxProfit = 0;
        
        for(int i=1;i<prices.length;i++){
            // 若今天价格高于前面几天的最低价格，则可以卖出。
            // 此时，计算今天卖出利润多少，是否比已计算的利润更高
            if(prices[i]>minPrice && maxProfit<(prices[i]-minPrice)){
                maxProfit = prices[i]-minPrice;
            }
            
            // 若今天价格低于前几天的最低价格，则更新最低价格
            if(prices[i]<minPrice){
                minPrice = prices[i];
            }
        }
        return maxProfit;
    }
}
