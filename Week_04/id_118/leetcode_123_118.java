// https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/
// 123.买卖股票的最佳时机3
// 是在 122 的基础上，加了限制条件，不能对所有值做累加，只能取最大的两个求和
class Solution {
    public int maxProfit(int[] prices) {
        
        ArrayList<Integer> profit = new ArrayList();
        
        // 1. 数组为空，或只有一个元素，则最大利润为0
        if(prices.length<=1){
            return 0;
        }
        
        int totalMaxProfit = 0;
        
        // 
        for(int i=1;i<prices.length;i++){
            // 左侧闭区间：[0,i]
            // 右侧闭区间：[i+1,length-1]
            int leftMaxProfit = maxProfit(prices,0,i);
            int rightMaxProfit = maxProfit(prices,i+1,prices.length-1);
            if(leftMaxProfit+rightMaxProfit >totalProfit){
                totalProfit = leftMaxProfit+rightMaxProfit;
            }
        }
        
        return totalProfit;
    }
    
    
    // 求闭区间 [from,to] 做一笔交易的最大值。
    int maxProfit(int[] prices,int from,int to){
        if(from>=to){
            return 0;
        }
        if(from+1==to){
            return prices[to]-prices[from]>0?prices[to]-prices[from]:0;
        }
        
        int minPrice = prices[from];
        int maxProfit = 0;
        for(int i=from+1;i<prices.length && i<=to;i++){
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
