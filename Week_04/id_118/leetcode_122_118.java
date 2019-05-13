// https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
// 122.买卖股票的最佳时机2
// 和 121 不一样的是，121 要求买买一次获得最大利润，122 要求多次买卖，获得最大利润，且不可以同时参与多笔交易
// 这样问题可以拆解为多个区间找最大差值的问题
// 由于可以多次买卖，所以我们只需要找到所有的独立的“单调递增区间”，然后计算其差值之和即可。
class Solution {
    public int maxProfit(int[] prices) {
        
        int totalProfit = 0;
        
        // 1. 数组为空，或只有一个元素，则最大利润为0
        if(prices.length<=1){
            return 0;
        }
        
        int partLeft = prices[0];
        int partRight = prices[0];
        
        // 2. 从1开始，寻找并累加单调区间左右差值
        for(int i=1;i<prices.length;i++){
            if(prices[i]>partRight){
                partRight = prices[i];
            }
            if(prices[i]<partRight){
                totalProfit += (partRight-partLeft);
                partLeft = prices[i];
                partRight = prices[i];
            }
        }
        
        // 3. 最后一个小区间
        if(partLeft!=partRight){
            totalProfit += (partRight-partLeft);
        }
        
        return totalProfit;
    }
}
